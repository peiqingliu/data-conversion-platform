package com.yousu.dataconverterplateform.module.slave.controller;

import com.yousu.dataconverterplateform.common.util.ResultUtil;
import com.yousu.dataconverterplateform.common.vo.Result;
import com.yousu.dataconverterplateform.module.slave.entity.SystemUser;
import com.yousu.dataconverterplateform.module.slave.service.SystemUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Liupeiqing
 * @Date 2020/3/9 22:04
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/system/user")
@AllArgsConstructor
public class SystemUserController {

    private SystemUserService systemUserService;

    @PostMapping("/login")
    public  Result<SystemUser> findUserByUserNameAndPassword(@RequestBody SystemUser u){
        SystemUser user =
                systemUserService.findUserByUserNameAndPassword(u.getUsername(),u.getPassword());
        if (user != null){
            return new ResultUtil<SystemUser>().setData(user);
        }else {
            return new ResultUtil<SystemUser>().setErrorMsg("用户名或者密码错误");
        }

    }



}
