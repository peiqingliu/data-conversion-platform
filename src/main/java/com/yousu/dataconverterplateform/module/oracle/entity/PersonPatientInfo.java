package com.yousu.dataconverterplateform.module.oracle.entity;

import com.yousu.dataconverterplateform.module.oracle.key.PersonPatientInfoKey;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/11 15:07
 * @File PersonPatientInfo
 * @Software IntelliJ IDEA
 * @description 患者基本信息
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "PERSON_PATIENT_INFO")
@IdClass(PersonPatientInfoKey.class)
public class PersonPatientInfo implements RowMapper<PersonPatientInfo>, Serializable {

    // 复合主键要用这个注解
//    @EmbeddedId
//    private PersonPatientInfoKey id;

    @Id
    @Column(name = "ORG_ID")
    private String ORG_ID;
    @Id
    @Column(name = "OPERATIONFLAG")
    private String OPERATIONFLAG;
    @Id
    @Column(name = "PATIENT_ID")
    private String PATIENT_ID;
    @Id
    @Column(name = "VISIT_TYPE")
    private String VISIT_TYPE;
    private String ORG_NAME;
    private String PATIENT_NAME;
    private String NAME_PHONETIC;
    private String GENDER;
    private Date BIRTH_DATE;
    private String BIRTH_PLACE;
    private String BIRTH_PROV_CODE;
    private String BIRTH_PROV_NAME;
    private String BIRTH_CITY_CODE;
    private String BIRTH_CITY_NAME;
    private String BIRTH_COUNTY_CODE;
    private String BIRTH_COUNTY_NAME;
    private String BIRTH_TOWN_CODE;
    private String BIRTH_TOWN_NAME;
    private String NATIONALITY;
    private String ETHNIC_GROUP;
    private String MARITAL_STATUS;
    private String CAREER;
    private String DEGREE;
    private String BLOOD_TYPE_ABO;
    private String BLOOD_TYPE_RH;
    private String IDENTITY_CARD_NO;
    private String HOUSEHOLD_NO;
    private String PASSPORT_NO;
    private String MILITARY_ID;
    private String INS_CARD_TYPE;
    private String INS_CARD_ID;
    private String HEALTH_CARD_NO;
    private String INS_TYPE_CODE;
    private String INS_TYPE_NAME;
    private String INS_PROP_CODE;
    private String INS_PROP_NAME;
    private String NATIVE_PLACE;
    private String PERMANENT_ADDR;
    private String PERM_PROV_CODE;
    private String PERM_PROV_NAME;
    private String PERM_CITY_CODE;
    private String PERM_CITY_NAME;
    private String PERM_COUNTY_CODE;
    private String PERM_COUNTY_NAME;
    private String PERM_TOWN_CODE;
    private String PERM_TOWN_NAME;
    private String DEAD_TAG;
    private Date DEAD_DATE;
    private Date CREATE_DATE;
    private String CREATED_BY_ID;
    private String CREATED_BY_NAME;
    private Date CREATETIME;
    private String UPLOADTIME;
    private String UPDATEFLAG = "0";
    private String HEALTH_CARD_ISSUE_AREA;
    private String PERSON_LIVE_TYPE;
    private String CENTER_FLAG = "0";
    private String HEALTH_RECORD_CODE;
    private String AGE2;
    private String BIRTH_PLACE2;
    private String ACADEMIC_DEGREE;
    private String MAILING_ADDRESS2;
    private String MAILING_ADDRESS3;
    private String MAILING_ADDRESS4;
    private String ATTACHED_ADDRESS;
    private String ATTACHED_HUJIADDRESS;
    private String ISPOOR;

    @SneakyThrows
    @Override
    public PersonPatientInfo mapRow(ResultSet rs, int i) throws SQLException {
        PersonPatientInfo personPatientInfo = new PersonPatientInfo();
        personPatientInfo.setORG_ID(rs.getString("ORG_ID"));
        personPatientInfo.setOPERATIONFLAG(rs.getString("OPERATIONFLAG"));
        personPatientInfo.setPATIENT_ID(rs.getString("PATIENT_ID"));
        personPatientInfo.setVISIT_TYPE(rs.getString("VISIT_TYPE"));
        personPatientInfo.setORG_NAME(rs.getString("ORG_NAME"));
        personPatientInfo.setPATIENT_NAME(rs.getString("PATIENT_NAME"));
        personPatientInfo.setNAME_PHONETIC(rs.getString("NAME_PHONETIC"));
        personPatientInfo.setGENDER(rs.getString("GENDER"));
        //BIRTH_DATE 在sqlserver中为字符串类型，在oracle中为日期类型
        Date BIRTH_DATE = DateUtils.parseDate(rs.getString("BIRTH_DATE"),"dd/MM/yyyy HH:mm:ss");
        personPatientInfo.setBIRTH_DATE(BIRTH_DATE);
        personPatientInfo.setBIRTH_PLACE(rs.getString("BIRTH_PLACE"));
        personPatientInfo.setBIRTH_PROV_CODE(rs.getString("BIRTH_PROV_CODE"));
        personPatientInfo.setBIRTH_PROV_NAME(rs.getString("BIRTH_PROV_NAME"));
        personPatientInfo.setBIRTH_CITY_CODE(rs.getString("BIRTH_CITY_CODE"));
        personPatientInfo.setBIRTH_CITY_NAME(rs.getString("BIRTH_CITY_NAME"));
        personPatientInfo.setBIRTH_COUNTY_CODE(rs.getString("BIRTH_COUNTY_CODE"));
        personPatientInfo.setBIRTH_COUNTY_NAME(rs.getString("BIRTH_COUNTY_NAME"));
        personPatientInfo.setBIRTH_TOWN_CODE(rs.getString("BIRTH_TOWN_CODE"));
        personPatientInfo.setBIRTH_TOWN_NAME(rs.getString("BIRTH_TOWN_NAME"));
        personPatientInfo.setNATIONALITY(rs.getString("NATIONALITY"));
        personPatientInfo.setETHNIC_GROUP(rs.getString("ETHNIC_GROUP"));
        personPatientInfo.setMARITAL_STATUS(rs.getString("MARITAL_STATUS"));
        personPatientInfo.setCAREER(rs.getString("CAREER"));
        personPatientInfo.setDEGREE(rs.getString("DEGREE"));
        personPatientInfo.setBLOOD_TYPE_ABO(rs.getString("BLOOD_TYPE_ABO"));
        personPatientInfo.setBLOOD_TYPE_RH(rs.getString("BLOOD_TYPE_RH"));
        personPatientInfo.setIDENTITY_CARD_NO(rs.getString("IDENTITY_CARD_NO"));
        personPatientInfo.setHOUSEHOLD_NO(rs.getString("HOUSEHOLD_NO"));
        personPatientInfo.setPASSPORT_NO(rs.getString("PASSPORT_NO"));
        personPatientInfo.setMILITARY_ID(rs.getString("MILITARY_ID"));
        personPatientInfo.setINS_CARD_TYPE(rs.getString("INS_CARD_TYPE"));
        personPatientInfo.setINS_CARD_ID(rs.getString("INS_CARD_ID"));
        personPatientInfo.setHEALTH_CARD_NO(rs.getString("HEALTH_CARD_NO"));
        personPatientInfo.setHEALTH_CARD_ISSUE_AREA(rs.getString("HEALTH_CARD_ISSUE_AREA"));
        personPatientInfo.setPERSON_LIVE_TYPE(rs.getString("PERSON_LIVE_TYPE"));
        personPatientInfo.setINS_TYPE_CODE(rs.getString("INS_TYPE_CODE"));
        personPatientInfo.setINS_TYPE_NAME(rs.getString("INS_TYPE_NAME"));
        personPatientInfo.setINS_PROP_CODE(rs.getString("INS_PROP_CODE"));
        personPatientInfo.setINS_PROP_NAME(rs.getString("INS_PROP_NAME"));
        personPatientInfo.setNATIVE_PLACE(rs.getString("NATIVE_PLACE"));
        personPatientInfo.setPERMANENT_ADDR(rs.getString("PERMANENT_ADDR"));
        personPatientInfo.setPERM_PROV_CODE(rs.getString("PERM_PROV_CODE"));
        personPatientInfo.setPERM_PROV_NAME(rs.getString("PERM_PROV_NAME"));
        personPatientInfo.setPERM_CITY_CODE(rs.getString("PERM_CITY_CODE"));
        personPatientInfo.setPERM_CITY_NAME(rs.getString("PERM_CITY_NAME"));
        personPatientInfo.setPERM_COUNTY_CODE(rs.getString("PERM_COUNTY_CODE"));
        personPatientInfo.setPERM_CITY_NAME(rs.getString("PERM_COUNTY_NAME"));
        personPatientInfo.setPERM_TOWN_CODE(rs.getString("PERM_TOWN_CODE"));
        personPatientInfo.setPERM_TOWN_NAME(rs.getString("PERM_TOWN_NAME"));
        personPatientInfo.setDEAD_TAG(rs.getString("DEAD_TAG"));
        personPatientInfo.setDEAD_DATE(rs.getDate("DEAD_DATE"));
        // 同上
        Date CREATE_DATE = DateUtils.parseDate(rs.getString("CREATE_DATE"),"dd/MM/yyyy HH:mm:ss");
        personPatientInfo.setCREATE_DATE(CREATE_DATE);
        personPatientInfo.setCREATED_BY_ID(rs.getString("CREATED_BY_ID"));
        personPatientInfo.setCREATED_BY_NAME(rs.getString("CREATED_BY_NAME"));
        Date CREATETIME = DateUtils.parseDate(rs.getString("CREATETIME"),"dd/MM/yyyy HH:mm:ss");
        personPatientInfo.setCREATETIME(CREATETIME);
        personPatientInfo.setHEALTH_RECORD_CODE(rs.getString("HEALTH_RECORD_CODE"));
        personPatientInfo.setAGE2(rs.getString("AGE2"));
        personPatientInfo.setBIRTH_PLACE2(rs.getString("BIRTH_PLACE2"));
        personPatientInfo.setACADEMIC_DEGREE(rs.getString("ACADEMIC_DEGREE"));
        personPatientInfo.setMAILING_ADDRESS2(rs.getString("MAILING_ADDRESS2"));
        personPatientInfo.setMAILING_ADDRESS3(rs.getString("MAILING_ADDRESS3"));
        personPatientInfo.setMAILING_ADDRESS4(rs.getString("MAILING_ADDRESS4"));
        personPatientInfo.setATTACHED_ADDRESS(rs.getString("ATTACHED_ADDRESS"));
        personPatientInfo.setATTACHED_HUJIADDRESS(rs.getString("ATTACHED_HUJIADDRESS"));
        personPatientInfo.setISPOOR(rs.getString("ISPOOR"));
        return personPatientInfo;
    }
}
