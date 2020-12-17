package com.yousu.dataconverterplateform.module.oracle.repository;

import com.yousu.dataconverterplateform.module.oracle.entity.PatientContactorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/17 14:00
 * @File PatientContactorInfoRepository
 * @Software IntelliJ IDEA
 * @description todo
 */
public interface PatientContactorInfoRepository  extends JpaRepository<PatientContactorInfo, String>, JpaSpecificationExecutor<PatientContactorInfo> {
}
