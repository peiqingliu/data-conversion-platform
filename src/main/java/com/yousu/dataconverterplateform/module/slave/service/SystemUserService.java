package com.yousu.dataconverterplateform.module.slave.service;

import com.yousu.dataconverterplateform.module.slave.entity.SystemUser;

/**
 * @Author Liupeiqing
 * @Date 2020/3/11 22:27
 * @Version 1.0
 */
public interface SystemUserService {

    SystemUser findUserByUserNameAndPassword(String username,String password);
}
