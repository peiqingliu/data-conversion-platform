package com.yousu.dataconverterplateform.module.oracle.repository;

import com.yousu.dataconverterplateform.module.oracle.entity.BasicExamInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-17 22:34
 */
public interface BasicExamInfoRepository extends JpaRepository<BasicExamInfo, String>, JpaSpecificationExecutor<BasicExamInfo> {
}
