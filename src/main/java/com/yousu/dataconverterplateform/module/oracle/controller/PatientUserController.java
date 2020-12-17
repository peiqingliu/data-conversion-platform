package com.yousu.dataconverterplateform.module.oracle.controller;

import com.yousu.dataconverterplateform.common.util.ResultUtil;
import com.yousu.dataconverterplateform.common.vo.Result;
import com.yousu.dataconverterplateform.module.oracle.entity.PatientUser;
import com.yousu.dataconverterplateform.module.oracle.service.PatientUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther Liupeiqing
 * @Date 2020-12-02 20:51
 */
@Slf4j
@RestController
@RequestMapping("/system/patientUser")
@AllArgsConstructor
public class PatientUserController {


    private final PatientUserService patientUserService;


    @GetMapping("/findAllUser")
    public Result<List<PatientUser>> findAllUser() {
        List<PatientUser> patientUsers =  patientUserService.findAll();
        return new ResultUtil<List<PatientUser>>().setData(patientUsers);
    }
}

