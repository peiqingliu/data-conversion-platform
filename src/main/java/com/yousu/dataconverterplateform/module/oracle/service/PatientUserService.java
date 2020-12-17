package com.yousu.dataconverterplateform.module.oracle.service;

import com.yousu.dataconverterplateform.module.oracle.entity.PatientUser;

import java.util.List;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-02 20:49
 */
public interface PatientUserService {

    PatientUser save(PatientUser patientUser);

    List<PatientUser> findAll();
}
