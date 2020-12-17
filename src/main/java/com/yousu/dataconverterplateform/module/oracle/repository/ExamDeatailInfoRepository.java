package com.yousu.dataconverterplateform.module.oracle.repository;

import com.yousu.dataconverterplateform.module.oracle.entity.ExamDeatailInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-17 22:53
 */
public interface ExamDeatailInfoRepository extends JpaRepository<ExamDeatailInfo, String>, JpaSpecificationExecutor<ExamDeatailInfo> {
}
