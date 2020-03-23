package com.yousu.dataconverterplateform.module.slave.repository;

import com.yousu.dataconverterplateform.module.slave.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author Liupeiqing
 * @Date 2020/3/9 21:19
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<SystemUser, String>, JpaSpecificationExecutor<SystemUser> {

    SystemUser findByUsernameAndPassword(String username,String password);
}
