package com.yousu.dataconverterplateform.module.oracle.controller;

import com.yousu.dataconverterplateform.module.oracle.service.impl.SourceDataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/12/12 15:31
 * @File DataSynchronousController
 * @Software IntelliJ IDEA
 * @description 数据同步主入口
 */
@Slf4j
@RestController
@RequestMapping("/system/data/synchronization")
@AllArgsConstructor
public class DataSynchronousController {

    private final SourceDataService sourceDataService;

    @RequestMapping("/start")
    public String start() {
        sourceDataService.selectPersonPatientInfoList();
        return "success";
    }
}
