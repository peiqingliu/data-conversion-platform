package com.yousu.dataconverterplateform.module.oracle.service.impl;

import com.yousu.dataconverterplateform.module.oracle.entity.PatientDischargeAdmin;
import com.yousu.dataconverterplateform.module.oracle.repository.PatientDischargeAdminRepository;
import com.yousu.dataconverterplateform.module.oracle.service.PatientDischargeAdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/16 15:20
 * @File PatientDischargeAdminServiceImpl
 * @Software IntelliJ IDEA
 * @description todo
 */
@Slf4j
@Service
@AllArgsConstructor
public class PatientDischargeAdminServiceImpl implements PatientDischargeAdminService {
    private final PatientDischargeAdminRepository patientDischargeAdminRepository;
    @Override
    public void saveOrUpdate(PatientDischargeAdmin patientDischargeAdmin) {
        patientDischargeAdminRepository.save(patientDischargeAdmin);
    }
}
