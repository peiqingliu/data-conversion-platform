package com.yousu.dataconverterplateform.module.task;

import com.yousu.dataconverterplateform.module.slave.entity.InterfaceInformation;
import com.yousu.dataconverterplateform.module.slave.service.InterfaceInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author peiqing Liu
 * @Date 2020/4/6 23:00
 * @Version 1.0
 */
@Service
public class SysJobRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SysJobRunner.class);

    @Autowired
    private InterfaceInformationService interfaceInformationService;

    @Autowired
    private CronTaskRegistrar cronTaskRegistrar;

    @Override
    public void run(String... args) throws Exception {
//        List<InterfaceInformation> interfaceInformations =
//                interfaceInformationService.findAllByWhetherOpen(1);
//        if (interfaceInformations !=null && interfaceInformations.size() > 0) {
//            for (InterfaceInformation job : interfaceInformations) {
//                cronTaskRegistrar.addCronTask(job);
//            }
//            logger.info("定时任务已加载完毕...");
//        }
    }
}
