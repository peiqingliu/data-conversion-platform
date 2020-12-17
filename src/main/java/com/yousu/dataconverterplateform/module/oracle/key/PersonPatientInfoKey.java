package com.yousu.dataconverterplateform.module.oracle.key;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/11 16:09
 * @File PersonPatientInfoKey
 * @Software IntelliJ IDEA
 * @description todo
 */
@ToString
@Data
@Embeddable
public class PersonPatientInfoKey implements Serializable {

    @Column(name = "ORG_ID")
    private String ORG_ID;

    @Column(name = "OPERATIONFLAG")
    private String OPERATIONFLAG;

    @Column(name = "PATIENT_ID")
    private String PATIENT_ID;

    @Column(name = "VISIT_TYPE")
    private String VISIT_TYPE;

}
