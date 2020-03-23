package com.yousu.dataconverterplateform.module.slave.service.impl;

import com.yousu.dataconverterplateform.module.slave.entity.SystemUser;
import com.yousu.dataconverterplateform.module.slave.repository.UserRepository;
import com.yousu.dataconverterplateform.module.slave.service.SystemUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Liupeiqing
 * @Date 2020/3/11 22:28
 * @Version 1.0
 */
@Slf4j
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public SystemUser findUserByUserNameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
