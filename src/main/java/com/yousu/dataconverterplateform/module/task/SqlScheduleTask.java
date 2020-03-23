package com.yousu.dataconverterplateform.module.task;

import com.yousu.dataconverterplateform.module.slave.entity.InterfaceInformation;
import com.yousu.dataconverterplateform.module.slave.service.InterfaceInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ContextLifecycleScheduledTaskRegistrar;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.Task;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.List;

/**
 * @Author Liupeiqing
 * @Date 2020/3/16 22:36
 * @Version 1.0  开启多线程定时任务
 */
@Slf4j
@Configuration
public class SqlScheduleTask  implements SchedulingConfigurer {


    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    private static List<InterfaceInformation> tasks;
    private static boolean initialized = false;
    private static ContextLifecycleScheduledTaskRegistrar taskRegistrar;

    @Autowired
    private  InterfaceInformationService interfaceInformationService;

    /**
     * @Description: 每隔一小时 扫描一次任务配置,重构定时任务时,把线程池中的任务关闭
     * @Param: []  0 0/10 * * * ?   0 0 0/1 * * ?
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void bTask() {
        try {
            if (initialized) {
                threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown( false );
                threadPoolTaskScheduler.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        /**
         * 获取所有开启的任务
         */

        tasks = interfaceInformationService.findAllByWhetherOpen(1);
        log.info("准备开启定时任务:" + tasks.size());
        //通过校验的数据，执行定时任务
        int count = 0;
        if (tasks.size() > 0) {
            for (int i = 0;i<tasks.size();i++){
                try {
                    scheduledTaskRegistrar.addTriggerTask(getRunnable(tasks.get(i)),getTrigger(tasks.get(i)));
                    count++;
                }catch (Exception e){
                    log.error("task start error:" + tasks.get(i).getInterfaceName() + ";" + tasks.get(i).getInterfaceCode());
                }
            }
        }else {
            bTask();
        }
    }


    /**
     *  获取每一个接口的执行任务
     * @param interfaceInformation
     * @return
     */
    private Runnable getRunnable(InterfaceInformation interfaceInformation){

        return new Runnable() {
            @Override
            public void run() {
                String interfaceName = interfaceInformation.getInterfaceName();
                log.info("接口任务开始执行" + Thread.currentThread().getName() + ";" + interfaceName);
            }
        };
    }

    /**
     * 获取 trigger
     * @return
     */
    private Trigger getTrigger(InterfaceInformation interfaceInformation){
        return new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger trigger = new CronTrigger(interfaceInformation.getCron());
                return trigger.nextExecutionTime(triggerContext);
            }
        };
    }
}
