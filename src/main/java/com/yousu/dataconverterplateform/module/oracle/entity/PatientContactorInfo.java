package com.yousu.dataconverterplateform.module.oracle.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/16 17:06
 * @File PatientContactorInfo
 * @Software IntelliJ IDEA
 * @description 患者联系人信息
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "PATIENT_CONTACTOR_INFO")
public class PatientContactorInfo implements RowMapper<PatientContactorInfo>, Serializable {

    @NotEmpty
    private String ORG_ID;
    @NotEmpty
    private String OPERATIONFLAG;
    @NotEmpty
    private String VISIT_ID;
    @NotEmpty
    private String VISIT_TYPE;
    private Integer PRIORITY;
    @NotEmpty
    private String ORG_NAME;
    @Id
    @NotEmpty
    private String PATIENT_ID;
    @NotEmpty
    private String PERSON_NAME;
    @NotEmpty
    private String RELATIONSHIP;
    private String PHONE_NUMBER;
    @NotEmpty
    private String ADDRESS;
    private String ADDR_PROV_CODE;
    private String ADDR_PROV_NAME;
    private String ADDR_CITY_CODE;
    private String ADDR_CITY_NAME;
    private String ADDR_COUNTY_CODE;
    private String ADDR_COUNTY_NAME;
    private String ADDR_TOWN_CODE;
    private String ADDR_TOWN_NAME;
    @NotEmpty
    private String ZIP_CODE;
    private String EMAILADDRESS;
    private String HOMEPHONE;
    private String MAILINGADDRESS_CODE;
    private String MAILINGADDRESS_NAME;
    private String PHONENO;

    @Override
    public PatientContactorInfo mapRow(ResultSet rs, int i) throws SQLException {
        PatientContactorInfo patientContactorInfo = new PatientContactorInfo();
        patientContactorInfo.setORG_ID(rs.getString("ORG_ID"));
        patientContactorInfo.setOPERATIONFLAG(rs.getString("OPERATIONFLAG"));
        patientContactorInfo.setVISIT_ID(rs.getString("VISIT_ID"));
        patientContactorInfo.setVISIT_TYPE(rs.getString("VISIT_TYPE"));
        patientContactorInfo.setPRIORITY(rs.getInt("PRIORITY"));
        patientContactorInfo.setPERSON_NAME(rs.getString("PERSON_NAME"));
        patientContactorInfo.setRELATIONSHIP(rs.getString("RELATIONSHIP"));
        patientContactorInfo.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
        patientContactorInfo.setADDRESS(rs.getString("ADDRESS"));
        patientContactorInfo.setADDR_PROV_CODE(rs.getString("ADDR_PROV_CODE"));
        patientContactorInfo.setADDR_PROV_NAME(rs.getString("ADDR_PROV_NAME"));
        patientContactorInfo.setADDR_CITY_CODE(rs.getString("ADDR_CITY_CODE"));
        patientContactorInfo.setADDR_CITY_NAME(rs.getString("ADDR_CITY_NAME"));
        patientContactorInfo.setADDR_COUNTY_CODE(rs.getString("ADDR_COUNTY_CODE"));
        patientContactorInfo.setADDR_COUNTY_NAME(rs.getString("ADDR_COUNTY_NAME"));
        patientContactorInfo.setADDR_TOWN_CODE(rs.getString("ADDR_TOWN_CODE"));
        patientContactorInfo.setADDR_TOWN_NAME(rs.getString("ADDR_TOWN_NAME"));
        patientContactorInfo.setZIP_CODE(rs.getString("ZIP_CODE"));
        patientContactorInfo.setEMAILADDRESS(rs.getString("EMAILADDRESS"));
        patientContactorInfo.setHOMEPHONE(rs.getString("HOMEPHONE"));
        patientContactorInfo.setMAILINGADDRESS_CODE(rs.getString("MAILINGADDRESS_CODE"));
        patientContactorInfo.setMAILINGADDRESS_NAME(rs.getString("MAILINGADDRESS_NAME"));
        patientContactorInfo.setPHONENO(rs.getString("PHONENO"));
        return patientContactorInfo;

    }
}
