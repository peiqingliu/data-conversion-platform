package com.yousu.dataconverterplateform.module.oracle.service.impl;

import com.yousu.dataconverterplateform.module.oracle.entity.PatientUser;
import com.yousu.dataconverterplateform.module.oracle.repository.PatientUserRepository;
import com.yousu.dataconverterplateform.module.oracle.service.PatientUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-02 20:49
 */
@Slf4j
@Service
@AllArgsConstructor
public class PatientUserServiceImpl implements PatientUserService {

    private final PatientUserRepository patientUserRepository;

    @Override
    public PatientUser save(PatientUser patientUser) {
        return patientUserRepository.save(patientUser);
    }

    @Override
    public List<PatientUser> findAll() {
        return patientUserRepository.findAll();
    }
}

