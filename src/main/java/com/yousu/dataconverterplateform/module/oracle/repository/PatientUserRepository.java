package com.yousu.dataconverterplateform.module.oracle.repository;

import com.yousu.dataconverterplateform.module.oracle.entity.PatientUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-02 20:44
 */
@Repository
public interface PatientUserRepository extends JpaRepository<PatientUser, String>, JpaSpecificationExecutor<PatientUser>  {
}
