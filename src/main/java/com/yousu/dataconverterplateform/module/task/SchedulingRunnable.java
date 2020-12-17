package com.yousu.dataconverterplateform.module.task;

import com.yousu.dataconverterplateform.module.slave.entity.InterfaceInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author peiqing Liu
 * @Date 2020/4/6 21:18
 * @Version 1.0
 */
public class SchedulingRunnable implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(SchedulingRunnable.class);


    private InterfaceInformation interfaceInformation;

    public SchedulingRunnable(InterfaceInformation interfaceInformation){
        this.interfaceInformation = interfaceInformation;
    }

    @Override
    public void run() {
        logger.info("定时任务开始执行:" + interfaceInformation.getId());
        long startTime = System.currentTimeMillis();
        try {
            logger.info("执行业务代码");
        }catch (Exception e){
            logger.error("定时任务执行失败");
        }
    }
}
