package com.yousu.dataconverterplateform.module.slave.repository;

import com.yousu.dataconverterplateform.module.slave.entity.SystemDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author Liupeiqing
 * @Date 2020/3/15 22:04
 * @Version 1.0
 */
public interface SystemDictRepository extends JpaRepository<SystemDict, String>, JpaSpecificationExecutor<SystemDict> {
}
