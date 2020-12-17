package com.yousu.dataconverterplateform.module.oracle.entity;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.base.Strings;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/12 14:04
 * @File PatientVisitInfo
 * @Software IntelliJ IDEA
 * @description 患者就诊信息
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "PATIENT_VISIT_INFO")
public class PatientVisitInfo implements RowMapper<PatientVisitInfo>, Serializable {

    @NotEmpty
    private String ORG_ID;
    @NotEmpty
    private String VISIT_ID;
    @NotEmpty
    private String OPERATIONFLAG;
    @NotEmpty
    private String VISIT_COUNT;
    @NotEmpty
    private String ORG_NAME;
    @Id
    @NotEmpty
    private String PATIENT_ID;
    @NotEmpty
    private String VISIT_TYPE;
    @NotEmpty
    private String DEPT_CODE;
    @NotEmpty
    private String DEPT_NAME;
    private String WARD_CODE;
    private String WARD_NAME;
    @NotEmpty
    @JsonFormat(timezone = "GMT+8", pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date VISIT_TIME;
    @NotEmpty
    private String ADM_WAY;

    @NotEmpty
    @JsonFormat(timezone = "GMT+8", pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date ADM_DATE_TIME;

    private Date ADM_DEPT_DATE_TIME;
    private String BED_CODE;
    private int PATIENT_CONDITION;
    private int NURSING_CLASS;
    private Date DISCHARGE_DATE_TIME;
    private String DISCHARGE_DISPOSITION;
    private String DISCHARGE_MEMO;
    private int READMISSION;
    private String READMISSION_PURPOSE;
    private String DIRECTOR_ID;
    private String DIRECTOR_NAME;
    private String DEPUTY_DIRECTOR_ID;
    private String DEPUTY_DIRECTOR_NAME;
    @NotEmpty
    private String ATTENDING_DOCTOR_ID;
    @NotEmpty
    private String ATTENDING_DOCTOR_NAME;
    @NotEmpty
    private String RESIDENT_DOCTOR_ID;
    @NotEmpty
    private String RESIDENT_DOCTOR_NAME;
    private String PRIMARY_NURSE_ID;
    private String CONTINUING_PHYSICIANID;
    private String CONTINUING_PHYSICIANNAME;
    private String MAILING_ADDR;
    private String MAILING_ADDR_PROV_CODE;
    private String MAILING_ADDR_PROV_NAME;
    private String MAILING_ADDR_CITY_CODE;
    private String MAILING_ADDR_CITY_NAME;
    private String MAILING_ADDR_COUNTY_CODE;
    private String MAILING_ADDR_COUNTY_NAME;
    private String MAILING_ADDR_TOWN_CODE;
    private String MAILING_ADDR_TOWN_NAME;
    private String MAILING_PHONE_NO;
    private String BUINESS_ADDR;
    private String BUINESS_PHONE_NO;
    private String CHIED_COMPLAINT;
    private String PAST_HISTORY;
    @JsonFormat(timezone = "GMT+8", pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date CREATETIME = new DateTime();
    private Date UPLOADTIME = new DateTime();
    private String UPDATEFLAG = "0";
    private String BUINESS_COM_NAME;
    private String BUINESS_ZIP_CODE;
    private String CHS_MED_DIAGNOSE;
    private String OUTPATIENT_REG_TYPE;
    private String PATIENT_VISIT_STATUS;
    private String DISEASE_HISTORY;
    private String ALLERGY_HISTORY;
    private String GENETIC_HISTORY;
    private char CENTER_FLAG = '0';
    private String PROVINCIALCODE;
    private String PROVINCIALNAME;
    private String CITYCODE;
    private String CITYNAME;
    private String AREACODE;
    private String AREANAME;
    private String FAMLIYCODE;
    private String PERSONCODE;
    private String HEIGHT;
    private String WEIGHT;
    private String TREATMENTCODE;
    private String TREATMENTNAME;
    private String COMPLICATIONCODE;
    private String COMPLICATIONNAME;
    private String REFERRAL_TYPECODE ;
    private String REFERRAL_TYPENAME;
    private String REFERRAL_NO;
    private Date REFERRAL_DATE;
    private String CIVIL_NOTICE;
    private String BIRTH_NO;
    private String HEALTH_RECORD_CODE;
    @Digits(integer=18, fraction=4)
    private Double ENABLE_MONEY;
    private String FINANCE_YEAR;
    @Digits(integer=18, fraction=4)
    private Double FUNDPAY_MONEY;
    @Digits(integer=18, fraction=4)
    private Double CIVIL_MONEY;
    @Digits(integer=18, fraction=4)
    private Double CRITICAL_MONEY ;
    @Digits(integer=18, fraction=4)
    private Double CRITICAL_COST;

    @SneakyThrows
    @Override
    public PatientVisitInfo mapRow(ResultSet rs, int i) throws SQLException {
        PatientVisitInfo patientVisitInfo = new PatientVisitInfo();
        patientVisitInfo.setORG_ID(rs.getString("ORG_ID"));
        patientVisitInfo.setOPERATIONFLAG(rs.getString("OPERATIONFLAG"));
        patientVisitInfo.setVISIT_ID(rs.getString("VISIT_ID"));
        patientVisitInfo.setVISIT_TYPE(rs.getString("VISIT_TYPE"));
        patientVisitInfo.setVISIT_COUNT(rs.getString("VISIT_COUNT"));
        patientVisitInfo.setORG_NAME(rs.getString("ORG_NAME"));
        patientVisitInfo.setPATIENT_ID(rs.getString("PATIENT_ID"));
        patientVisitInfo.setDEPT_CODE(rs.getString("DEPT_CODE"));
        patientVisitInfo.setDEPT_NAME(rs.getString("DEPT_NAME"));
        patientVisitInfo.setWARD_CODE(rs.getString("WARD_CODE"));
        patientVisitInfo.setWARD_NAME(rs.getString("WARD_NAME"));
        Date VISIT_TIME = DateUtils.parseDate(rs.getString("VISIT_TIME"),"dd/MM/yyyy HH:mm:ss");
        patientVisitInfo.setVISIT_TIME(VISIT_TIME);
        patientVisitInfo.setADM_WAY(rs.getString("ADM_WAY"));
        Date ADM_DATE_TIME = DateUtils.parseDate(rs.getString("ADM_DATE_TIME"),"dd/MM/yyyy HH:mm:ss");
        patientVisitInfo.setADM_DATE_TIME(ADM_DATE_TIME);
        if (!Strings.isNullOrEmpty(rs.getString("ADM_DEPT_DATE_TIME"))) {
            Date ADM_DEPT_DATE_TIME = DateUtils.parseDate(rs.getString("ADM_DEPT_DATE_TIME"),"dd/MM/yyyy HH:mm:ss");
            patientVisitInfo.setADM_DEPT_DATE_TIME(ADM_DEPT_DATE_TIME);
        }
        patientVisitInfo.setBED_CODE(rs.getString("BED_CODE"));
        patientVisitInfo.setPATIENT_CONDITION(rs.getInt("PATIENT_CONDITION"));
        patientVisitInfo.setNURSING_CLASS(rs.getInt("NURSING_CLASS"));
        Date DISCHARGE_DATE_TIME = DateUtils.parseDate(rs.getString("DISCHARGE_DATE_TIME"),"dd/MM/yyyy HH:mm:ss");
        patientVisitInfo.setDISCHARGE_DATE_TIME(DISCHARGE_DATE_TIME);
        patientVisitInfo.setDISCHARGE_DISPOSITION(rs.getString("DISCHARGE_DISPOSITION"));
        patientVisitInfo.setDISCHARGE_MEMO(rs.getString("DISCHARGE_MEMO"));
        patientVisitInfo.setREADMISSION(rs.getInt("READMISSION"));
        patientVisitInfo.setREADMISSION_PURPOSE(rs.getString("READMISSION_PURPOSE"));
        patientVisitInfo.setDIRECTOR_ID(rs.getString("DIRECTOR_ID"));
        patientVisitInfo.setDIRECTOR_NAME(rs.getString("DIRECTOR_NAME"));
        patientVisitInfo.setDEPUTY_DIRECTOR_ID(rs.getString("DEPUTY_DIRECTOR_ID"));
        patientVisitInfo.setDEPUTY_DIRECTOR_NAME(rs.getString("DEPUTY_DIRECTOR_NAME"));
        patientVisitInfo.setATTENDING_DOCTOR_ID(rs.getString("ATTENDING_DOCTOR_ID"));
        patientVisitInfo.setATTENDING_DOCTOR_NAME(rs.getString("ATTENDING_DOCTOR_NAME"));
        patientVisitInfo.setRESIDENT_DOCTOR_ID(rs.getString("RESIDENT_DOCTOR_ID"));
        patientVisitInfo.setRESIDENT_DOCTOR_NAME(rs.getString("RESIDENT_DOCTOR_NAME"));
        patientVisitInfo.setPRIMARY_NURSE_ID(rs.getString("PRIMARY_NURSE_ID"));
        patientVisitInfo.setCONTINUING_PHYSICIANID(rs.getString("CONTINUING_PHYSICIANID"));
        patientVisitInfo.setCONTINUING_PHYSICIANNAME(rs.getString("CONTINUING_PHYSICIANNAME"));
        patientVisitInfo.setMAILING_ADDR(rs.getString("MAILING_ADDR"));
        patientVisitInfo.setMAILING_ADDR_PROV_CODE(rs.getString("MAILING_ADDR_PROV_CODE"));
        patientVisitInfo.setMAILING_ADDR_PROV_NAME(rs.getString("MAILING_ADDR_PROV_NAME"));
        patientVisitInfo.setMAILING_ADDR_CITY_CODE(rs.getString("MAILING_ADDR_CITY_CODE"));
        patientVisitInfo.setMAILING_ADDR_CITY_NAME(rs.getString("MAILING_ADDR_CITY_NAME"));
        patientVisitInfo.setMAILING_ADDR_COUNTY_CODE(rs.getString("MAILING_ADDR_COUNTY_CODE"));
        patientVisitInfo.setMAILING_ADDR_COUNTY_NAME(rs.getString("MAILING_ADDR_COUNTY_NAME"));
        patientVisitInfo.setMAILING_ADDR_TOWN_CODE(rs.getString("MAILING_ADDR_TOWN_CODE"));
        patientVisitInfo.setMAILING_ADDR_TOWN_NAME(rs.getString("MAILING_ADDR_TOWN_NAME"));
        patientVisitInfo.setMAILING_PHONE_NO(rs.getString("MAILING_PHONE_NO"));
        patientVisitInfo.setBUINESS_ADDR(rs.getString("BUINESS_ADDR"));
        patientVisitInfo.setBUINESS_PHONE_NO(rs.getString("BUINESS_PHONE_NO"));
        patientVisitInfo.setBUINESS_COM_NAME(rs.getString("BUINESS_COM_NAME"));
        patientVisitInfo.setBUINESS_ZIP_CODE(rs.getString("BUINESS_ZIP_CODE"));
        patientVisitInfo.setCHIED_COMPLAINT(rs.getString("CHIED_COMPLAINT"));
        patientVisitInfo.setCHS_MED_DIAGNOSE(rs.getString("CHS_MED_DIAGNOSE"));
        patientVisitInfo.setPAST_HISTORY(rs.getString("PAST_HISTORY"));
        patientVisitInfo.setOUTPATIENT_REG_TYPE(rs.getString("OUTPATIENT_REG_TYPE"));
        patientVisitInfo.setPATIENT_VISIT_STATUS(rs.getString("PATIENT_VISIT_STATUS"));
        patientVisitInfo.setDISEASE_HISTORY(rs.getString("DISEASE_HISTORY"));
        patientVisitInfo.setALLERGY_HISTORY(rs.getString("ALLERGY_HISTORY"));
        patientVisitInfo.setGENETIC_HISTORY(rs.getString("GENETIC_HISTORY"));
        patientVisitInfo.setPROVINCIALCODE(rs.getString("PROVINCIALCODE"));
        patientVisitInfo.setPROVINCIALNAME(rs.getString("PROVINCIALNAME"));
        patientVisitInfo.setCITYCODE(rs.getString("CITYCODE"));
        patientVisitInfo.setCITYNAME(rs.getString("CITYNAME"));
        patientVisitInfo.setAREACODE(rs.getString("AREACODE"));
        patientVisitInfo.setAREANAME(rs.getString("AREANAME"));
        patientVisitInfo.setFAMLIYCODE(rs.getString("FAMLIYCODE"));
        patientVisitInfo.setPERSONCODE(rs.getString("PERSONCODE"));
        patientVisitInfo.setHEIGHT(rs.getString("HEIGHT"));
        patientVisitInfo.setWEIGHT(rs.getString("WEIGHT"));
        patientVisitInfo.setTREATMENTCODE(rs.getString("TREATMENTCODE"));
        patientVisitInfo.setTREATMENTNAME(rs.getString("TREATMENTNAME"));
        patientVisitInfo.setCOMPLICATIONCODE(rs.getString("COMPLICATIONCODE"));
        patientVisitInfo.setCOMPLICATIONNAME(rs.getString("COMPLICATIONNAME"));
        patientVisitInfo.setREFERRAL_TYPECODE(rs.getString("REFERRAL_TYPECODE"));
        patientVisitInfo.setREFERRAL_TYPENAME(rs.getString("REFERRAL_TYPENAME"));
        patientVisitInfo.setREFERRAL_NO(rs.getString("REFERRAL_NO"));
        if (!Strings.isNullOrEmpty(rs.getString("REFERRAL_DATE"))) {
            Date REFERRAL_DATE = DateUtils.parseDate(rs.getString("REFERRAL_DATE"),"dd/MM/yyyy HH:mm:ss");
            patientVisitInfo.setREFERRAL_DATE(REFERRAL_DATE);
        }
        patientVisitInfo.setCIVIL_NOTICE(rs.getString("CIVIL_NOTICE"));
        patientVisitInfo.setBIRTH_NO(rs.getString("BIRTH_NO"));
        patientVisitInfo.setHEALTH_RECORD_CODE(rs.getString("HEALTH_RECORD_CODE"));
        patientVisitInfo.setENABLE_MONEY(rs.getDouble("ENABLE_MONEY"));
        patientVisitInfo.setFINANCE_YEAR(rs.getString("FINANCE_YEAR"));
        patientVisitInfo.setFUNDPAY_MONEY(rs.getDouble("FUNDPAY_MONEY"));
        patientVisitInfo.setCIVIL_MONEY(rs.getDouble("CIVIL_MONEY"));
        patientVisitInfo.setCRITICAL_MONEY(rs.getDouble("CRITICAL_MONEY"));
        patientVisitInfo.setCRITICAL_COST(rs.getDouble("CRITICAL_COST"));
        return patientVisitInfo;
    }
}
