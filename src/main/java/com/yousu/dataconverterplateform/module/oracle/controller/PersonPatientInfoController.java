package com.yousu.dataconverterplateform.module.oracle.controller;

import com.yousu.dataconverterplateform.module.oracle.service.impl.PersonPatientInfoServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/10 18:12
 * @File PersonPatientInfoController
 * @Software IntelliJ IDEA
 * @description todo
 */
@Slf4j
@RestController
@RequestMapping("/system/personPatientInfo")
@AllArgsConstructor
public class PersonPatientInfoController {

    private final PersonPatientInfoServiceImpl personPatientInfoService;


}
