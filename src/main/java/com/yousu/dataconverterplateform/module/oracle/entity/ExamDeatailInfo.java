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
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-17 22:38
 * 3.4.2.	检查项目信息
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "EXAM_DEATAIL_INFO")
public class ExamDeatailInfo implements RowMapper<ExamDeatailInfo>, Serializable {

    @NotEmpty
    private String ORG_ID;
    @NotEmpty
    private String OPERATIONFLAG;
    @NotEmpty
    private String EXAM_REQ_ID;
    @NotEmpty
    private String EXAM_ID;
    @NotEmpty
    private int EXAM_ITEM_NO;
    @NotEmpty
    private String ORG_NAME;
    @NotEmpty
    private String EXAM_CLASS;
    @NotEmpty
    private String EXAM_SUB_CLASS;
    @NotEmpty
    private Date EXAM_TIME;
    @NotEmpty
    private String EXAM_ITEM_NAME;
    @NotEmpty
    private String EXAM_ITEM_CODE;
    private String EXAM_ITEM_MEMO;
    @NotEmpty
    private String EXAM_CLASS_NAME;
    @NotEmpty
    private String EXAM_SUB_CLASS_NAME;
    private String INSTRUMENT_CODE;
    private String INSTRUMENT_NAME;
    private String INSTRUMENTTYPE_CODE;
    private String INSTRUMENTTYPE_NAME;
    private Date SCHEDULEDATETIME;
    private String SCHEDULEDEPT_CODE;
    private String SCHEDULEDEPT_NAME;
    private String SCHEDULEDOCTOR_CODE;
    private String SCHEDULEDOCTOR_NAME;
    private String SCHEDULE_LOCATION;
    private String EXAM_DEPT_CODE;
    private String EXAM_DEPT_NAME;
    private String EXAM_DOCTOR_CODE;
    private String EXAM_DOCTOR_NAME;
    private String EXAM_SITE;
    @SneakyThrows
    @Override
    public ExamDeatailInfo mapRow(ResultSet rs, int i) throws SQLException {
        ExamDeatailInfo examDeatailInfo = new ExamDeatailInfo();
        examDeatailInfo.setORG_ID(rs.getString("ORG_ID"));
        examDeatailInfo.setOPERATIONFLAG(rs.getString("OPERATIONFLAG"));
        examDeatailInfo.setEXAM_REQ_ID(rs.getString("EXAM_REQ_ID"));
        examDeatailInfo.setEXAM_ID(rs.getString("EXAM_ID"));
        examDeatailInfo.setEXAM_ITEM_NO(rs.getInt("EXAM_ITEM_NO"));
        examDeatailInfo.setORG_NAME(rs.getString("ORG_NAME"));
        examDeatailInfo.setEXAM_CLASS(rs.getString("EXAM_CLASS"));
        examDeatailInfo.setEXAM_SUB_CLASS(rs.getString("EXAM_SUB_CLASS"));
        if (!Strings.isNullOrEmpty(rs.getString("EXAM_TIME"))) {
            Date EXAM_TIME = DateUtils.parseDate(rs.getString("EXAM_TIME"),"dd/MM/yyyy HH:mm:ss");
            examDeatailInfo.setEXAM_TIME(EXAM_TIME);
        }
        examDeatailInfo.setEXAM_ITEM_NAME(rs.getString("EXAM_ITEM_NAME"));
        examDeatailInfo.setEXAM_ITEM_CODE(rs.getString("EXAM_ITEM_CODE"));
        examDeatailInfo.setEXAM_ITEM_MEMO(rs.getString("EXAM_ITEM_MEMO"));
        examDeatailInfo.setEXAM_CLASS_NAME(rs.getString("EXAM_CLASS_NAME"));
        examDeatailInfo.setEXAM_SUB_CLASS_NAME(rs.getString("EXAM_SUB_CLASS_NAME"));
        examDeatailInfo.setINSTRUMENT_CODE(rs.getString("INSTRUMENT_CODE"));
        examDeatailInfo.setINSTRUMENT_NAME(rs.getString("INSTRUMENT_NAME"));
        examDeatailInfo.setINSTRUMENTTYPE_CODE(rs.getString("INSTRUMENTTYPE_CODE"));
        examDeatailInfo.setINSTRUMENTTYPE_NAME(rs.getString("INSTRUMENTTYPE_NAME"));
        if (!Strings.isNullOrEmpty(rs.getString("SCHEDULEDATETIME"))) {
            Date SCHEDULEDATETIME = DateUtils.parseDate(rs.getString("SCHEDULEDATETIME"),"dd/MM/yyyy HH:mm:ss");
            examDeatailInfo.setSCHEDULEDATETIME(SCHEDULEDATETIME);
        }
        examDeatailInfo.setSCHEDULEDEPT_CODE(rs.getString("SCHEDULEDEPT_CODE"));
        examDeatailInfo.setSCHEDULEDEPT_NAME(rs.getString("SCHEDULEDEPT_NAME"));
        examDeatailInfo.setSCHEDULEDOCTOR_CODE(rs.getString("SCHEDULEDOCTOR_CODE"));
        examDeatailInfo.setSCHEDULEDOCTOR_NAME(rs.getString("SCHEDULEDOCTOR_NAME"));
        examDeatailInfo.setSCHEDULE_LOCATION(rs.getString("SCHEDULE_LOCATION"));
        examDeatailInfo.setEXAM_DEPT_CODE(rs.getString("EXAM_DEPT_CODE"));
        examDeatailInfo.setEXAM_DEPT_NAME(rs.getString("EXAM_DEPT_NAME"));
        examDeatailInfo.setEXAM_DOCTOR_CODE(rs.getString("EXAM_DOCTOR_CODE"));
        examDeatailInfo.setEXAM_DOCTOR_NAME(rs.getString("EXAM_DOCTOR_NAME"));
        examDeatailInfo.setEXAM_SITE(rs.getString("EXAM_SITE"));
        return examDeatailInfo;
    }
}

