package com.yousu.dataconverterplateform.module.slave.service.impl;

import cn.hutool.core.date.DateUtil;
import com.google.common.base.Strings;
import com.yousu.dataconverterplateform.common.util.ConvertUtil;
import com.yousu.dataconverterplateform.common.util.StringUtils;
import com.yousu.dataconverterplateform.module.slave.entity.GetDPCSExLog;
import com.yousu.dataconverterplateform.module.slave.entity.InterfaceInformation;
import com.yousu.dataconverterplateform.module.slave.entity.OriginPerson;
import com.yousu.dataconverterplateform.module.slave.repository.GetDPCSExLogRepository;
import com.yousu.dataconverterplateform.module.slave.service.BaseService;
import com.yousu.dataconverterplateform.module.slave.service.OriginPersonService;
import com.yousu.dataconverterplateform.module.util.JacksonUtil;
import com.yousu.dataconverterplateform.module.util.SoapRunUtil;
import com.yousu.dataconverterplateform.module.util.SoapUtils;
import com.yousu.dataconverterplateform.module.webservice.PopulationIndexApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author peiqing Liu
 * @Date 2020/4/6 22:56
 * @Version 1.0
 */
@Slf4j
@Service
public class BaseServiceImpl implements BaseService {

    @Value("${yousu.posturl}")
    private  String posturl;

    @Value("${yousu.username}")
    private  String username;

    @Value("${yousu.password}")
    private  String password;

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate secondaryJdbcTemplate;


    @Autowired
    private SoapRunUtil soapRunUtil;

    @Autowired
    private JacksonUtil jacksonUtil;

    @Autowired
    private OriginPersonService originPersonService;

    @Autowired
    private GetDPCSExLogRepository getDPCSExLogRepository;

    //一次插入的条数，也就是分批的list大小
    private static final int pointsDataLimit = 500;


    @Override
    public void executeSql(InterfaceInformation interfaceInformation) {
        if (interfaceInformation.getInterfaceCode().equals("PopulationIndex")){
            log.info("executeSql:"+ interfaceInformation.getPrepareExecuteSql());
            List<Map<String, Object>> result = primaryJdbcTemplate.queryForList(interfaceInformation.getPrepareExecuteSql());
            log.info("查询完数据总条数"+result.size());
            for (int i=0;i<result.size();i++){
                    Map<String,Object> map = result.get(i);
                    String VAA15 = (String) map.get("VAA15");
                    String replaceString  = replaceSql(interfaceInformation.getDataModel(),VAA15);
                    String soapXml = setRequestHeader(interfaceInformation.getRequestHeader(),replaceString);
                    try {
                        String doPostSoap11 = SoapUtils.doPostNotSSL(posturl, soapXml, interfaceInformation.getSoapAction());
                        if (!Strings.isNullOrEmpty(doPostSoap11)){
                            OriginPerson originPerson = parseXml(doPostSoap11);
                            //保存数据
                            String id = originPersonService.findByIdNo(VAA15);
                            if (Strings.isNullOrEmpty(id)){
                                originPersonService.save(originPerson);
                            }else {
                                originPersonService.deleteById(id);
                                originPersonService.save(originPerson);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }else if (interfaceInformation.getInterfaceCode().equals("Get_DPCSEx")){
            String executeSql = interfaceInformation.getPrepareExecuteSql();
            Map<String,Object> sqlMap = jacksonUtil.JsonToMap(executeSql);
            String sql1 = (String) sqlMap.get("sql1");
            String [] sql1Array= sql1.split(",");
            String sql2 = (String) sqlMap.get("sql2");
            String [] sql2Array= sql2.split(",");
            String sql = "";
            if (interfaceInformation.getSearchTime() != 0){ //不是默认值
                sql = "select * from Get_DPCSEx where 1=1 and datediff(dd,PRESC_DATE,getdate()) <='"+interfaceInformation.getSearchTime()+"'; ";
            }else {
                sql = "select * from Get_DPCSEx where 1=1";
            }
            List<Map<String,Object>> result = primaryJdbcTemplate.queryForList(sql);
            Map<String, List<Map<String, Object>>> gList = result.stream().collect(Collectors.groupingBy(e -> e.get("VISIT_NO").toString()));

            //此时 就可以进行执行接口
            for (Map.Entry<String, List<Map<String, Object>>> entry : gList.entrySet()) {
                String k = entry.getKey();
                List<Map<String, Object>> vList = entry.getValue();
                try {
                    String personSql = "select vaa15 from person where vaa03 = '" + k + "' ;";
                    List<Map<String, Object>> list = primaryJdbcTemplate.queryForList(personSql);
                    if (list.size() > 0) {
                        Map<String, Object> map = list.get(0);
                        String idNo = (String) map.get("vaa15");
                        if (!Strings.isNullOrEmpty(idNo) && idNo.length() == 18) {
//                            String sqlIdNo = "select patient_id from t_origin_person WHERE id_no =  '" + idNo + "';";
//                            String patientId = secondaryJdbcTemplate.queryForObject(sqlIdNo, String.class);
                            String doPostSoapResponse = PopulationIndexApi.doPostSoap(posturl,username,password,idNo);
                            OriginPerson originPerson = parseXml(doPostSoapResponse);
                            if (originPerson != null){
                                if (!Strings.isNullOrEmpty(originPerson.getPatient_id())) {
                                        vList.forEach(item -> {
                                            item.put("PATIENT_ID", originPerson.getPatient_id());
                                        });
                                        //获取sql1的部分值
                                        Map<String, Object> sql1Map = new LinkedHashMap<>(16);
                                        //获取sql2的部分值
                                        List<Map<String, Object>> sql2MapList = new ArrayList<>(16);
                                        vList.forEach(m -> {
                                            Map<String, Object> sql2Map = new LinkedHashMap<>(16);
                                            for (String key : m.keySet()) {
                                                System.out.println(key);
                                                if (isContains(sql1Array, key)) {
                                                    Object value = m.get(key);
                                                    sql1Map.put(key, value);
                                                }
                                                if (isContains(sql2Array, key)) {
                                                    Object value = m.get(key);
                                                    sql2Map.put(key, value);
                                                }
                                            }
                                            sql2MapList.add(sql2Map);
                                        });
                                        //先判断是否已经上传，如果已经上传了，则不必在上传
                                        String reportNum = sql1Map.get("REPORT_NUM").toString();
                                        if (!Strings.isNullOrEmpty(reportNum)) {
                                            GetDPCSExLog getDPCSExLog = getDPCSExLogRepository.findByReportNum(reportNum);
                                            //只有不存在的时候，再上传
                                            if (getDPCSExLog == null) {
                                                //转换sql1的部分
                                                String mapString1 = ConvertUtil.parseMapToXml(sql1Map);
                                                String dataModel = replaceSql1(interfaceInformation.getDataModel(), mapString1);
                                                interfaceInformation.setDataModel(dataModel);
                                                log.info("查询sql2MapList:" + sql2MapList.size());
                                                int listSize = sql2MapList.size();
                                                if (listSize < 500) {
                                                    insertList(sql2MapList, interfaceInformation, sql1Map,idNo);
                                                } else {
                                                    List<Map<String, Object>> tempList = new ArrayList<>(500);
                                                    int maxSize = listSize - 1;
                                                    for (int i = 0; i < sql2MapList.size(); i++) {
                                                        //分批次处理
                                                        log.info("分批次处理");
                                                        tempList.add(sql2MapList.get(i));//循环将数据填入载体list
                                                        if (pointsDataLimit == tempList.size() || i == maxSize) {  //载体list达到要求,进行批量操作
                                                            //调用批量插入
                                                            log.info("调用批量插入");
                                                            insertList(tempList, interfaceInformation, sql1Map,idNo);
                                                            tempList.clear();//每次批量操作后,清空载体list,等待下次的数据填入
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                }
                            }
                        }

                    }
                } catch (Exception e) {
                    log.error("查询出现异常" + e);
                }
            }
        }else {  //常规
            String executeSql = interfaceInformation.getPrepareExecuteSql();
            if(interfaceInformation.getSearchTime() != 0){
                executeSql = executeSql + "where 1=1 and datediff(dd,REPORTTIME,getdate()) <=' "+interfaceInformation.getSearchTime()+"';";
            }
            List<Map<String, Object>> result = primaryJdbcTemplate.queryForList(executeSql);
            for (Map<String, Object> map : result){
                log.info("map" + map);
            }
        }
    }

    private void insertList(List<Map<String, Object>> tempList,InterfaceInformation interfaceInformation, Map<String,Object> sql1Map,String idNo){
        StringBuffer  mapString = new StringBuffer();
        for (int i=0;i<tempList.size();i++){
            Map<String,Object> m = tempList.get(i);
             mapString.append("<ITEM>");
             mapString.append(ConvertUtil.parseMapToXml(m));
             mapString.append("</ITEM>");
        }
        log.info("替换sql2前");
        String replaceString  = replaceSql2(interfaceInformation.getDataModel(),mapString.toString());
        log.info("完成sql2替换：" + replaceString);
        String soapXml = setRequestHeader(interfaceInformation.getRequestHeader(),replaceString);
        try {
            log.info("地贫检验设备报告上传结构：{soapXml}%n" + soapXml);
            String result = soapRunUtil.doPostSoap59(soapXml,interfaceInformation.getSoapAction());
            log.info("地贫检验设备报告返回信息：{result}%n" + result);
            Map<String, Object> m = jacksonUtil.multilayerXmlToMap(result);
            log.info("m" + m);
            Map<String,Object> m2 = (Map<String, Object>) m.get("Envelope");
            Map<String,Object> m3 = (Map<String, Object>) m2.get("Body");
            Map<String,Object> m4 = (Map<String, Object>) m3.get("Get_DPCSExResponse");
            String m5 = (String) m4.get("Get_DPCSExResult");
            if (m5.equals("1")){  //表示返回结果成功
                saveGetDPCSExLog(sql1Map,idNo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("调用第三方接口出错" + e);
        }

    }

    private void saveGetDPCSExLog(Map<String, Object> sql1Map,String idNo){
            GetDPCSExLog getDPCSExLog = new GetDPCSExLog();
            for (String key : sql1Map.keySet()) {
                System.out.println(key );
                if (key.equals("REPORT_NUM")){
                    String v= sql1Map.get("REPORT_NUM").toString();
                    getDPCSExLog.setReportNum(v);
                }
                if (key.equals("VISIT_NO")){
                    String v=  sql1Map.get("VISIT_NO").toString();
                    getDPCSExLog.setVisitNo(v);
                }

                if (key.equals("PRESC_DATE")){
                    String v= sql1Map.get("PRESC_DATE").toString();
                    Date date = DateUtil.parseDate(v).toJdkDate();
                    getDPCSExLog.setPrescDate(date);
                }

                if (key.equals("NAME")){
                    String v=  sql1Map.get("NAME").toString();
                    getDPCSExLog.setName(v);
                }

                if (key.equals("EXAMINATIONCODE")){
                    String v=  sql1Map.get("EXAMINATIONCODE").toString();
                    getDPCSExLog.setExaminationcode(v);
                }

                if (key.equals("PATIENT_ID")){
                    String v=  sql1Map.get("PATIENT_ID").toString();
                    getDPCSExLog.setPatientId(v);
                }
            }
            getDPCSExLog.setIdNo(idNo);
            getDPCSExLog.setOperateDate(new Date());
            getDPCSExLog.setAlreadyUploaded(1);

            getDPCSExLogRepository.save(getDPCSExLog);
    }

    private OriginPerson parseXml(String soapResponse){
        if (!Strings.isNullOrEmpty(soapResponse)){
            //截取字符串
            String string = StringUtils.subString(soapResponse,"<PopulationIndexResult>","</PopulationIndexResult>");
            String r = unescapeXml(string);
            log.info("r:" + r);
            String str = StringUtils.subString(r,"<index>","</index>");
            try {
                OriginPerson originPerson = jacksonUtil.xmlToJavabean(str, OriginPerson.class);
                return originPerson;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 替换sql
     * @param dataModel
     * @param mapString
     * @return
     */
    private String replaceSql(String dataModel,String mapString){
        dataModel=dataModel.replace("sql",mapString);
        return dataModel;
    }

    /**
     * 替换sql1
     * @param dataModel
     * @param mapString
     * @return
     */
    private String replaceSql1(String dataModel,String mapString){
        dataModel=dataModel.replace("sql1",mapString);
        return dataModel;
    }
    /**
     * 替换sql2
     * @param dataModel
     * @param mapString
     * @return
     */
    private String replaceSql2(String dataModel,String mapString){
        dataModel=dataModel.replace("<ITEM>\n" +
                "sql2\n" +
                "</ITEM>",mapString);
        return dataModel;
    }

    private String setRequestHeader(String requestHeader,String sqlString){
        requestHeader = requestHeader.replace("sql",sqlString);
        log.info("获取完成的请求参数:"+ requestHeader);
        return requestHeader;
    }


    private String unescapeXml(String str){
        str = str.replace("&lt;","<");
        str = str.replace("&gt;",">");
        log.info("获取完成的请求参数:"+ str);
        return str;
    }


    private  boolean isContains(String[] arr, String targetValue) {
        for(String s: arr){
            if(s.equals(targetValue))
                return true;
        }
        return false;
    }

}
