package com.yousu.dataconverterplateform.module.oracle.service.impl;

import com.yousu.dataconverterplateform.module.oracle.entity.PatientVisitInfo;
import com.yousu.dataconverterplateform.module.oracle.repository.PatientVisitInfoRepository;
import com.yousu.dataconverterplateform.module.oracle.service.PatientVisitInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/12 15:04
 * @File PatientVisitInfoServiceImpl
 * @Software IntelliJ IDEA
 * @description todo
 */
@Service
@Slf4j
@AllArgsConstructor
public class PatientVisitInfoServiceImpl implements PatientVisitInfoService {
    private final PatientVisitInfoRepository patientVisitInfoRepository;

    @Transactional
    @Override
    public void saveOrUpdate(PatientVisitInfo patientVisitInfo) {
        patientVisitInfoRepository.saveAndFlush(patientVisitInfo);
    }
}
