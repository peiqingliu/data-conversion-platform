package com.yousu.dataconverterplateform.module.oracle.service.impl;

import com.yousu.dataconverterplateform.module.oracle.entity.PatientContactorInfo;
import com.yousu.dataconverterplateform.module.oracle.repository.PatientContactorInfoRepository;
import com.yousu.dataconverterplateform.module.oracle.service.PatientContactorInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/17 14:04
 * @File PatientContactorInfoServiceImpl
 * @Software IntelliJ IDEA
 * @description todo
 */
@Slf4j
@Service
@AllArgsConstructor
public class PatientContactorInfoServiceImpl implements PatientContactorInfoService {

    private PatientContactorInfoRepository patientContactorInfoRepository;

    @Override
    public void saveOrUpdate(PatientContactorInfo patientContactorInfo) {
        patientContactorInfoRepository.save(patientContactorInfo);
    }
}
