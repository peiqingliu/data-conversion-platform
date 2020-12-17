package com.yousu.dataconverterplateform.module.oracle.service.impl;

import com.yousu.dataconverterplateform.module.oracle.entity.PersonPatientInfo;
import com.yousu.dataconverterplateform.module.oracle.repository.PersonPatientInfoRepository;
import com.yousu.dataconverterplateform.module.oracle.service.PatientVisitInfoService;
import com.yousu.dataconverterplateform.module.oracle.service.PersonPatientInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/10 18:00
 * @File PersonPatientInfoService
 * @Software IntelliJ IDEA
 * @description 3.1.1.	患者基本信息
 */
@Service
@Slf4j
@AllArgsConstructor
public class PersonPatientInfoServiceImpl implements PersonPatientInfoService {

    private final PersonPatientInfoRepository personPatientInfoRepository;
    private final PatientVisitInfoService patientVisitInfoService;
//    public void selectPersonPatientInfoList() {
//        String sql = "SELECT\n" +
//                "\tORG_ID ,\n" +
//                "\tOPERATIONFLAG,\n" +
//                "\tPATIENT_ID,\n" +
//                "\tVISIT_TYPE,\n" +
//                "\tORG_NAME,\n" +
//                "\tPATIENT_NAME,\n" +
//                "\tNAME_PHONETIC,\n" +
//                "\tGENDER,\n" +
//                "\tBIRTH_DATE,\n" +
//                "\tBIRTH_PLACE,\n" +
//                "\tBIRTH_PROV_CODE,\n" +
//                "\tBIRTH_PROV_NAME,\n" +
//                "\tBIRTH_CITY_CODE,\n" +
//                "\tBIRTH_CITY_NAME,\n" +
//                "\tBIRTH_COUNTY_CODE,\n" +
//                "\tBIRTH_COUNTY_NAME,\n" +
//                "\tBIRTH_TOWN_CODE,\n" +
//                "\tBIRTH_TOWN_NAME,\n" +
//                "\tNATIONALITY,\n" +
//                "\tETHNIC_GROUP,\n" +
//                "\tMARITAL_STATUS,\n" +
//                "\tCAREER,\n" +
//                "\tDEGREE,\n" +
//                "\tBLOOD_TYPE_ABO,\n" +
//                "\tBLOOD_TYPE_RH,\n" +
//                "\tIDENTITY_CARD_NO,\n" +
//                "\tHOUSEHOLD_NO,\n" +
//                "\tPASSPORT_NO,\n" +
//                "\tMILITARY_ID,\n" +
//                "\tINS_CARD_TYPE,\n" +
//                "\tINS_CARD_ID,\n" +
//                "\tHEALTH_CARD_NO,\n" +
//                "\tHEALTH_CARD_ISSUE_AREA,\n" +
//                "\tPERSON_LIVE_TYPE,\n" +
//                "\tINS_TYPE_CODE,\n" +
//                "\tINS_TYPE_NAME,\n" +
//                "\tINS_PROP_CODE,\n" +
//                "\tINS_PROP_NAME,\n" +
//                "\tNATIVE_PLACE,\n" +
//                "\tPERMANENT_ADDR,\n" +
//                "\tPERM_PROV_CODE,\n" +
//                "\tPERM_PROV_NAME,\n" +
//                "\tPERM_CITY_CODE,\n" +
//                "\tPERM_CITY_NAME,\n" +
//                "\tPERM_COUNTY_CODE,\n" +
//                "\tPERM_COUNTY_NAME,\n" +
//                "\tPERM_TOWN_CODE,\n" +
//                "\tPERM_TOWN_NAME,\n" +
//                "\tDEAD_TAG,\n" +
//                "\tDEAD_DATE,\n" +
//                "\tCREATE_DATE,\n" +
//                "\tCREATED_BY_ID,\n" +
//                "\tCREATED_BY_NAME,\n" +
//                "\tHEALTH_RECORD_CODE,\n" +
//                "\tCREATETIME,\n" +
//                "\tAGE2,\n" +
//                "\tBIRTH_PLACE2,\n" +
//                "\tACADEMIC_DEGREE,\n" +
//                "\tMAILING_ADDRESS2,\n" +
//                "\tMAILING_ADDRESS3,\n" +
//                "\tMAILING_ADDRESS4,\n" +
//                "\tATTACHED_ADDRESS,\n" +
//                "\tATTACHED_HUJIADDRESS,\n" +
//                "\tISPOOR\n" +
//                "FROM\n" +
//                "\tPERSON_PATIENT_INFO";
//        List<PersonPatientInfo> result = primaryJdbcTemplate.query(sql,new PersonPatientInfo());
//        log.info("查询到的人员总数" + result.size());
//        saveAll(result);
//    }

    @Override
    public void saveAll(List<PersonPatientInfo> personPatientInfos) {
        try {
            personPatientInfoRepository.saveAll(personPatientInfos);
        }catch (Exception e) {
            log.error("人员基本信息入库出错：" + e);
        }
    }

    @Override
    public void saveOrUpdate(PersonPatientInfo personPatientInfo) {
            personPatientInfoRepository.save(personPatientInfo);
    }
}
