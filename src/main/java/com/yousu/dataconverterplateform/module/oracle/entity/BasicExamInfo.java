package com.yousu.dataconverterplateform.module.oracle.entity;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/17 15:08
 * @File BasicExamInfo
 * @Software IntelliJ IDEA
 * @description todo
 */
public class BasicExamInfo {

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
    private String REQ_DATE_TIME;
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
    private String EXAM_TIME;
    private String EXAM_ID;
    @NotEmpty
    private String EXAM_STATUS;
    private String REGISTRATION_DATE;
    private String ORDER_IDENTIFIER;
    private Date LATEST_DATESERVICE_REQUIRED;
    private String PATIENT_REQUIREMENTS;
    private Integer SUPPLEMENTARY_TOFOLLOW;
    private String REASONFORREQUEST;
}
