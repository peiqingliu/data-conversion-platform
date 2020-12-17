package com.yousu.dataconverterplateform.module.oracle.service.impl;

import com.yousu.dataconverterplateform.module.oracle.entity.PatientContactorInfo;
import com.yousu.dataconverterplateform.module.oracle.entity.PatientDischargeAdmin;
import com.yousu.dataconverterplateform.module.oracle.entity.PatientVisitInfo;
import com.yousu.dataconverterplateform.module.oracle.entity.PersonPatientInfo;
import com.yousu.dataconverterplateform.module.oracle.service.PatientContactorInfoService;
import com.yousu.dataconverterplateform.module.oracle.service.PatientDischargeAdminService;
import com.yousu.dataconverterplateform.module.oracle.service.PatientVisitInfoService;
import com.yousu.dataconverterplateform.module.oracle.service.PersonPatientInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/12 15:20
 * @File SourceDataService
 * @Software IntelliJ IDEA
 * @description 数据源接口查询
 */
@Slf4j
@Component
@AllArgsConstructor
@Transactional
public class SourceDataService {

    private final JdbcTemplate primaryJdbcTemplate;
    // 患者基本信息接口
    private final PersonPatientInfoService personPatientInfoService;
    private final PatientVisitInfoService patientVisitInfoService;
    private final PatientDischargeAdminService patientDischargeAdminService;
    private final PatientContactorInfoService patientContactorInfoService;

    /**
     * 查询患者基本信息
     */
    public void selectPersonPatientInfoList() {
        String sql = "SELECT\n" +
                "\tORG_ID ,\n" +
                "\tOPERATIONFLAG,\n" +
                "\tPATIENT_ID,\n" +
                "\tVISIT_TYPE,\n" +
                "\tORG_NAME,\n" +
                "\tPATIENT_NAME,\n" +
                "\tNAME_PHONETIC,\n" +
                "\tGENDER,\n" +
                "\tBIRTH_DATE,\n" +
                "\tBIRTH_PLACE,\n" +
                "\tBIRTH_PROV_CODE,\n" +
                "\tBIRTH_PROV_NAME,\n" +
                "\tBIRTH_CITY_CODE,\n" +
                "\tBIRTH_CITY_NAME,\n" +
                "\tBIRTH_COUNTY_CODE,\n" +
                "\tBIRTH_COUNTY_NAME,\n" +
                "\tBIRTH_TOWN_CODE,\n" +
                "\tBIRTH_TOWN_NAME,\n" +
                "\tNATIONALITY,\n" +
                "\tETHNIC_GROUP,\n" +
                "\tMARITAL_STATUS,\n" +
                "\tCAREER,\n" +
                "\tDEGREE,\n" +
                "\tBLOOD_TYPE_ABO,\n" +
                "\tBLOOD_TYPE_RH,\n" +
                "\tIDENTITY_CARD_NO,\n" +
                "\tHOUSEHOLD_NO,\n" +
                "\tPASSPORT_NO,\n" +
                "\tMILITARY_ID,\n" +
                "\tINS_CARD_TYPE,\n" +
                "\tINS_CARD_ID,\n" +
                "\tHEALTH_CARD_NO,\n" +
                "\tHEALTH_CARD_ISSUE_AREA,\n" +
                "\tPERSON_LIVE_TYPE,\n" +
                "\tINS_TYPE_CODE,\n" +
                "\tINS_TYPE_NAME,\n" +
                "\tINS_PROP_CODE,\n" +
                "\tINS_PROP_NAME,\n" +
                "\tNATIVE_PLACE,\n" +
                "\tPERMANENT_ADDR,\n" +
                "\tPERM_PROV_CODE,\n" +
                "\tPERM_PROV_NAME,\n" +
                "\tPERM_CITY_CODE,\n" +
                "\tPERM_CITY_NAME,\n" +
                "\tPERM_COUNTY_CODE,\n" +
                "\tPERM_COUNTY_NAME,\n" +
                "\tPERM_TOWN_CODE,\n" +
                "\tPERM_TOWN_NAME,\n" +
                "\tDEAD_TAG,\n" +
                "\tDEAD_DATE,\n" +
                "\tCREATE_DATE,\n" +
                "\tCREATED_BY_ID,\n" +
                "\tCREATED_BY_NAME,\n" +
                "\tHEALTH_RECORD_CODE,\n" +
                "\tCREATETIME,\n" +
                "\tAGE2,\n" +
                "\tBIRTH_PLACE2,\n" +
                "\tACADEMIC_DEGREE,\n" +
                "\tMAILING_ADDRESS2,\n" +
                "\tMAILING_ADDRESS3,\n" +
                "\tMAILING_ADDRESS4,\n" +
                "\tATTACHED_ADDRESS,\n" +
                "\tATTACHED_HUJIADDRESS,\n" +
                "\tISPOOR\n" +
                "FROM\n" +
                "\tPERSON_PATIENT_INFO";
        List<PersonPatientInfo> result = primaryJdbcTemplate.query(sql, new PersonPatientInfo());
        log.info("查询到的患者人员总数" + result.size());
        for (PersonPatientInfo personPatientInfo : result) {
            savePatientData(personPatientInfo);
        }
    }

    @Async
    @Transactional(rollbackFor = Exception.class)
    public void savePatientData(PersonPatientInfo personPatientInfo){
        try {
            personPatientInfoService.saveOrUpdate(personPatientInfo);
            selectPatientVisitInfoByPatientId(personPatientInfo.getPATIENT_ID());
            selectPatientDischargeAdminByPatientId(personPatientInfo.getPATIENT_ID());
            selectPatientContactorInfoByPatientId(personPatientInfo.getPATIENT_ID());
        }catch (Exception e) {
            log.error("患者信息同步出错：" + e);
            log.error("患者基本信息：" + personPatientInfo.toString());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

    }

    /**
     * 2、患者就诊信息入库
     * @param patientId
     */
    private void selectPatientVisitInfoByPatientId(String patientId) {
        String sql = "select * from PATIENT_VISIT_INFO where PATIENT_ID = ? ";
        String[] params = new String[] { patientId};
        PatientVisitInfo patientVisitInfo = primaryJdbcTemplate.queryForObject(sql,params,new PatientVisitInfo());
        if (patientVisitInfo != null) {
            patientVisitInfoService.saveOrUpdate(patientVisitInfo);
        }
    }

    /**
     * 3、患者出院信息
     * @param patientId
     */
    private void selectPatientDischargeAdminByPatientId(String patientId) {
        String sql = "select * from PATIENT_DISCHARGEADMIN where PATIENT_ID = ? ";
        String[] params = new String[] { patientId};
        PatientDischargeAdmin patientDischargeAdmin = primaryJdbcTemplate.queryForObject(sql,params,new PatientDischargeAdmin());
        if (patientDischargeAdmin != null) {
            patientDischargeAdminService.saveOrUpdate(patientDischargeAdmin);
        }
    }

    /**
     * 4、患者联系人信息
     * @param patientId
     */
    private void selectPatientContactorInfoByPatientId(String patientId) {
        String sql = "select * from PATIENT_CONTACTOR_INFO where PATIENT_ID = ?";
        String[] params = new String[]{patientId};
        PatientContactorInfo patientContactorInfo = primaryJdbcTemplate.queryForObject(sql,params,new PatientContactorInfo());
        if (patientContactorInfo != null) {
            patientContactorInfoService.saveOrUpdate(patientContactorInfo);
        }
    }
}
