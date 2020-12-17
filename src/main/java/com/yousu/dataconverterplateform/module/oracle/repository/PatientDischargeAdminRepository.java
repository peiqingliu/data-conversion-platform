package com.yousu.dataconverterplateform.module.oracle.repository;

import com.yousu.dataconverterplateform.module.oracle.entity.PatientDischargeAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/16 15:20
 * @File PatientDischargeAdminRepository
 * @Software IntelliJ IDEA
 * @description todo
 */
public interface PatientDischargeAdminRepository extends JpaRepository<PatientDischargeAdmin, String>, JpaSpecificationExecutor<PatientDischargeAdmin> {
}
