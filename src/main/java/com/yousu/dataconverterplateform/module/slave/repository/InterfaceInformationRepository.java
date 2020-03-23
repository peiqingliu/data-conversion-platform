package com.yousu.dataconverterplateform.module.slave.repository;

import com.yousu.dataconverterplateform.module.slave.entity.InterfaceInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author Liupeiqing
 * @Date 2020/3/14 22:36
 * @Version 1.0
 */
public interface InterfaceInformationRepository extends JpaRepository<InterfaceInformation, String>, JpaSpecificationExecutor<InterfaceInformation> {

    List<InterfaceInformation> findAllByWhetherOpen(int whetherOpen);
}
