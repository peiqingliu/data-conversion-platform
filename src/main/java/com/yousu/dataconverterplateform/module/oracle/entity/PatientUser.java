package com.yousu.dataconverterplateform.module.oracle.entity;

import com.yousu.dataconverterplateform.common.util.SnowFlakeUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-02 20:42
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "T_PATIENT_USER")
public class PatientUser {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private String id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());
    private String username;
    private String sex;
    private Integer age;
}

