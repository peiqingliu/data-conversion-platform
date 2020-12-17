package com.yousu.dataconverterplateform.common.util;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Liu_peiqing
 * @Date: 2020/03/25/22:08
 * @Description: 用于转换
 */
@Slf4j
public class ConvertUtil {

    /**
     * 将list转成xml  key值作为标签，value作为值
     */
    public static String  parseListToXml(List<List<Map<String,Object>>> listListMaps){

        StringBuffer paramXml =  new StringBuffer();
        if (listListMaps.size() > 0){  //次数应该小于500
            paramXml.append("<?xml version=1.0 encoding=gb2312?>\n");
            for (List listMaps : listListMaps){
                if (listMaps.size() > 0){
                    for (int i=0;i<listMaps.size();i++){
                        Map<String,Object> map = (Map<String, Object>) listMaps.get(i);
                        for (Map.Entry<String, Object> m : map.entrySet()) {
                            paramXml.append("<" + m.getKey().toUpperCase() +">" + m.getValue() + "</"+m.getKey().toUpperCase()+">\n") ;
                        }
                    }
                }
            }
        }

        String soapxml =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://microsoft.com/webservices/\">\n" +
                        "   <soapenv:Header>\n" +
                        "      <web:MySoapHeader>\n" +
                        "         <web:Uname>bas4504210014</web:Uname><web:Password>45042100142816202@gxwst</web:Password>\n" +
                        "      </web:MySoapHeader>\n" +
                        "   </soapenv:Header>\n" +
                        "   <soapenv:Body>\n" +
                        "      <web:PopulationIndex> \n" +
                        "      <web:ProductId><![CDATA["
                        + paramXml +
                        "       ]]></web:ProductId></web:PopulationIndex>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>";
        log.info("转换后的soapxml:" + soapxml);
        return soapxml;
    }


    /**
     * 将map转成xml
     * @param map
     * @return
     */
    public static String parseMapToXml(Map<String,Object> map){
        StringBuffer paramXml =  new StringBuffer();
        for (Map.Entry<String, Object> m : map.entrySet()) {
            if (null == m.getValue()){
                paramXml.append("<"+m.getKey().toUpperCase()+"/>\n") ;
            }else {

                paramXml.append("<" + m.getKey().toUpperCase() +">" + m.getValue() + "</"+m.getKey().toUpperCase()+">\n") ;
            }
        }
        return paramXml.toString();
    }

    public static void main(String[] args) {
        List<List<Map<String,Object>>> lists = new ArrayList<>(16);
        List<Map<String,Object>> mapList = new ArrayList<>(16);
        Map<String,Object> map1 = new HashMap<>(16);
        map1.put("USERCODE","1234567890");
        Map<String,Object> map2 = new HashMap<>(16);
        map2.put("USERNAME","广西xxx医院");
        Map<String,Object> map3 = new HashMap<>(16);
        map3.put("YLFKFS","YLFKFS");
        Map<String,Object> map4 = new HashMap<>(16);
        map4.put("JKKH","2130087");
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        mapList.add(map4);
        lists.add(mapList);
        lists.add(mapList);
        parseListToXml(lists);
    }
}
