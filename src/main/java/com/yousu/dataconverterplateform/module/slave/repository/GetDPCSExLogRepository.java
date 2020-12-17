package com.yousu.dataconverterplateform.module.slave.repository;

import com.yousu.dataconverterplateform.module.slave.entity.GetDPCSExLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GetDPCSExLogRepository  extends JpaRepository<GetDPCSExLog, String>, JpaSpecificationExecutor<GetDPCSExLog> {

    GetDPCSExLog findByReportNum(String reportNum);
}
