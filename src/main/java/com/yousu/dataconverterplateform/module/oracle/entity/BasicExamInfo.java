package com.yousu.dataconverterplateform.module.oracle.entity;

import com.google.common.base.Strings;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.ToString;
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
 * @date 2020/12/17 15:08
 * @File BasicExamInfo
 * @Software IntelliJ IDEA
 * @description 3.4.1.	检查基本信息
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "BASIC_EXAM_INFO")
public class BasicExamInfo implements RowMapper<BasicExamInfo>, Serializable {

    @NotEmpty
    private String ORG_ID;
    @NotEmpty
    private String OPERATIONFLAG;
    @NotEmpty
    private String EXAM_REQ_ID;
    @NotEmpty
    private String ORG_NAME;
    @NotEmpty
    @Id
    private String PATIENT_ID;
    @NotEmpty
    private String VISIT_ID;
    @NotEmpty
    private String VISIT_TYPE;
    @NotEmpty
    private String PRIORITY;
    @NotEmpty
    private Date REQ_DATE_TIME;
    @NotEmpty
    private String REQ_DEPT_NAME;
    @NotEmpty
    private String REQ_DEPT_ID;
    @NotEmpty
    private String REQ_DOCTOR_NAME;
    private String REQ_DOCTOR_ID;
    private String EXAM_DEPT_CODE;
    private String EXAM_DEPT_NAME;
    private String EXAM_DOCTOR_CODE;
    private String EXAM_DOCTOR_NAME;
    private String PURPOSE;
    private String SYNDROM;
    private String SIGNS;
    private String RELEVANT_LAB_TEST;
    private String RELEVANT_DIAG;
    private String DIAGNOSIS;
    private String MEMO;
    private String BODY_SIGN;
    private String TRANSPORT_MODE;
    private Date EXAM_TIME;
    private String EXAM_ID;
    @NotEmpty
    private String EXAM_STATUS;
    private Date REGISTRATION_DATE;
    private String ORDER_IDENTIFIER;
    private Date LATEST_DATESERVICE_REQUIRED;
    private String PATIENT_REQUIREMENTS;
    private Integer SUPPLEMENTARY_TOFOLLOW;
    private String REASONFORREQUEST;

    @SneakyThrows
    @Override
    public BasicExamInfo mapRow(ResultSet rs, int i) throws SQLException {
        BasicExamInfo basicExamInfo = new BasicExamInfo();
        basicExamInfo.setORG_ID(rs.getString("ORG_ID"));
        basicExamInfo.setOPERATIONFLAG(rs.getString("OPERATIONFLAG"));
        basicExamInfo.setEXAM_REQ_ID(rs.getString("EXAM_REQ_ID"));
        basicExamInfo.setORG_NAME(rs.getString("ORG_NAME"));
        basicExamInfo.setPATIENT_ID(rs.getString("PATIENT_ID"));
        basicExamInfo.setVISIT_ID(rs.getString("VISIT_ID"));
        basicExamInfo.setVISIT_TYPE(rs.getString("VISIT_TYPE"));
        basicExamInfo.setPRIORITY(rs.getString("PRIORITY"));
        if (!Strings.isNullOrEmpty(rs.getString("REQ_DATE_TIME"))) {
            Date REQ_DATE_TIME = DateUtils.parseDate(rs.getString("REQ_DATE_TIME"),"dd/MM/yyyy HH:mm:ss");
            basicExamInfo.setREQ_DATE_TIME(REQ_DATE_TIME);
        }
        basicExamInfo.setREQ_DEPT_ID(rs.getString("REQ_DEPT_ID"));
        basicExamInfo.setREQ_DEPT_NAME(rs.getString("REQ_DEPT_NAME"));
        basicExamInfo.setREQ_DOCTOR_NAME(rs.getString("REQ_DOCTOR_NAME"));
        basicExamInfo.setREQ_DOCTOR_ID(rs.getString("REQ_DOCTOR_ID"));
        basicExamInfo.setEXAM_DEPT_CODE(rs.getString("EXAM_DEPT_CODE"));
        basicExamInfo.setREQ_DEPT_NAME(rs.getString("EXAM_DEPT_NAME"));
        basicExamInfo.setEXAM_DOCTOR_CODE(rs.getString("EXAM_DOCTOR_CODE"));
        basicExamInfo.setEXAM_DOCTOR_NAME(rs.getString("EXAM_DOCTOR_NAME"));
        basicExamInfo.setPRIORITY(rs.getString("PURPOSE"));
        basicExamInfo.setSYNDROM(rs.getString("SYNDROM"));
        basicExamInfo.setSIGNS(rs.getString("SIGNS"));
        basicExamInfo.setRELEVANT_LAB_TEST(rs.getString("RELEVANT_LAB_TEST"));
        basicExamInfo.setRELEVANT_DIAG(rs.getString("RELEVANT_DIAG"));
        basicExamInfo.setDIAGNOSIS(rs.getString("DIAGNOSIS"));
        basicExamInfo.setMEMO(rs.getString("MEMO"));
        basicExamInfo.setBODY_SIGN(rs.getString("BODY_SIGN"));
        basicExamInfo.setTRANSPORT_MODE(rs.getString("TRANSPORT_MODE"));
        if (!Strings.isNullOrEmpty(rs.getString("EXAM_TIME"))) {
            Date EXAM_TIME = DateUtils.parseDate(rs.getString("EXAM_TIME"),"dd/MM/yyyy HH:mm:ss");
            basicExamInfo.setEXAM_TIME(EXAM_TIME);
        }
        basicExamInfo.setEXAM_ID(rs.getString("EXAM_ID"));
        basicExamInfo.setEXAM_STATUS(rs.getString("EXAM_STATUS"));
        if (!Strings.isNullOrEmpty(rs.getString("REGISTRATION_DATE"))) {
            Date REGISTRATION_DATE = DateUtils.parseDate(rs.getString("REGISTRATION_DATE"),"dd/MM/yyyy HH:mm:ss");
            basicExamInfo.setREGISTRATION_DATE(REGISTRATION_DATE);
        }
        basicExamInfo.setORDER_IDENTIFIER(rs.getString("ORDER_IDENTIFIER"));
        if (!Strings.isNullOrEmpty(rs.getString("LATEST_DATESERVICE_REQUIRED"))) {
            Date LATEST_DATESERVICE_REQUIRED = DateUtils.parseDate(rs.getString("LATEST_DATESERVICE_REQUIRED"),"dd/MM/yyyy HH:mm:ss");
            basicExamInfo.setLATEST_DATESERVICE_REQUIRED(LATEST_DATESERVICE_REQUIRED);
        }
        basicExamInfo.setPATIENT_REQUIREMENTS(rs.getString("PATIENT_REQUIREMENTS"));
        basicExamInfo.setSUPPLEMENTARY_TOFOLLOW(rs.getInt("SUPPLEMENTARY_TOFOLLOW"));
        basicExamInfo.setREASONFORREQUEST(rs.getString("REASONFORREQUEST"));
        return basicExamInfo;
    }
}
