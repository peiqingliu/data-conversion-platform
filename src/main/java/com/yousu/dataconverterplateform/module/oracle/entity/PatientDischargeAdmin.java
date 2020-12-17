package com.yousu.dataconverterplateform.module.oracle.entity;

import com.google.common.base.Strings;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.jdbc.core.RowMapper;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/16 14:17
 * @File PatientDischargeAdmin
 * @Software IntelliJ IDEA
 * @description 3.1.3.	患者出院信息
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "PATIENT_DISCHARGEADMIN")
public class PatientDischargeAdmin implements RowMapper<PatientDischargeAdmin>, Serializable {

    @NotEmpty
    private String ORG_ID;
    @NotEmpty
    private String OPERATIONFLAG;
    @NotEmpty
    private String VISIT_ID;
    @Id
    @NotEmpty
    private String PATIENT_ID;
    @NotEmpty
    private String ORDER_ID;
    @NotEmpty
    private Date ADM_DATE_TIME;
    @NotEmpty
    private Date DISCHARGE_DATE_TIME;
    @NotEmpty
    private String IN_HOSPITAL_DAYS;
    @NotEmpty
    private String DESTINATION_TYPE_CODE;
    @NotEmpty
    private String DESTINATION_TYPE_NAME;
    @NotEmpty
    private String DISCHARGE_TYPE;
    private String DISCHARGING_DEPARTMENT;
    private String DISCHARGING_WARD;
    private String FURTHER_ACTION;
    private String DISCHARGE_DECISION;
    private Date PLANNED_DISCHARGE;

    @SneakyThrows
    @Override
    public PatientDischargeAdmin mapRow(ResultSet rs, int i) throws SQLException {
        PatientDischargeAdmin patientDischargeAdmin = new PatientDischargeAdmin();
        patientDischargeAdmin.setORG_ID(rs.getString("ORG_ID"));
        patientDischargeAdmin.setOPERATIONFLAG(rs.getString("OPERATIONFLAG"));
        patientDischargeAdmin.setVISIT_ID(rs.getString("VISIT_ID"));
        patientDischargeAdmin.setPATIENT_ID(rs.getString("PATIENT_ID"));
        patientDischargeAdmin.setORDER_ID(rs.getString("ORDER_ID"));
        if (!Strings.isNullOrEmpty(rs.getString("ADM_DATE_TIME"))) {
            Date ADM_DATE_TIME = DateUtils.parseDate(rs.getString("ADM_DATE_TIME"),"dd/MM/yyyy HH:mm:ss");
            patientDischargeAdmin.setADM_DATE_TIME(ADM_DATE_TIME);
        }
        if (!Strings.isNullOrEmpty(rs.getString("DISCHARGE_DATE_TIME"))) {
            Date DISCHARGE_DATE_TIME = DateUtils.parseDate(rs.getString("DISCHARGE_DATE_TIME"),"dd/MM/yyyy HH:mm:ss");
            patientDischargeAdmin.setDISCHARGE_DATE_TIME(DISCHARGE_DATE_TIME);
        }
        patientDischargeAdmin.setIN_HOSPITAL_DAYS(rs.getString("IN_HOSPITAL_DAYS"));
        patientDischargeAdmin.setDESTINATION_TYPE_CODE(rs.getString("DESTINATION_TYPE_CODE"));
        patientDischargeAdmin.setDESTINATION_TYPE_NAME(rs.getString("DESTINATION_TYPE_NAME"));
        patientDischargeAdmin.setDISCHARGE_TYPE(rs.getString("DISCHARGE_TYPE"));
        patientDischargeAdmin.setDISCHARGING_DEPARTMENT(rs.getString("DISCHARGING_DEPARTMENT"));
        patientDischargeAdmin.setDISCHARGING_WARD(rs.getString("DISCHARGING_WARD"));
        patientDischargeAdmin.setFURTHER_ACTION(rs.getString("FURTHER_ACTION"));
        patientDischargeAdmin.setDISCHARGE_DECISION(rs.getString("DISCHARGE_DECISION"));
        if (!Strings.isNullOrEmpty(rs.getString("PLANNED_DISCHARGE"))) {
            Date PLANNED_DISCHARGE = DateUtils.parseDate(rs.getString("PLANNED_DISCHARGE"),"dd/MM/yyyy HH:mm:ss");
            patientDischargeAdmin.setPLANNED_DISCHARGE(PLANNED_DISCHARGE);
        }
        return patientDischargeAdmin;
    }
}
