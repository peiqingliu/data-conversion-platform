package com.yousu.dataconverterplateform.module.oracle.repository;

import com.yousu.dataconverterplateform.module.oracle.entity.PatientVisitInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/12 15:03
 * @File PatientVisitInfoRepository
 * @Software IntelliJ IDEA
 * @description todo
 */
public interface PatientVisitInfoRepository extends JpaRepository<PatientVisitInfo, String>, JpaSpecificationExecutor<PatientVisitInfo> {
}
