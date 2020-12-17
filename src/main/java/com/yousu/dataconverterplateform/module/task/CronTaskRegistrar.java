package com.yousu.dataconverterplateform.module.task;

import com.google.common.base.Strings;
import com.yousu.dataconverterplateform.module.slave.entity.InterfaceInformation;
import com.yousu.dataconverterplateform.module.slave.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author peiqing Liu
 * @Date 2020/4/6 21:12
 * @Version 1.0
 */
@Slf4j
@Component
public class CronTaskRegistrar implements DisposableBean {

    private final Map<String,ScheduledTask> scheduledTasks = new ConcurrentHashMap<>(16);

    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    private BaseService baseService;


    public TaskScheduler getScheduler() {
        return this.taskScheduler;
    }

    public void addCronTask(InterfaceInformation interfaceInformation) {
        addCronTask(new CronTask(getRunnable(interfaceInformation), interfaceInformation.getCron()),interfaceInformation.getId());
    }

    private void addCronTask(CronTask cronTask,String taskId) {
        if (cronTask != null) {
            if (this.scheduledTasks.containsKey(taskId)) {
                removeCronTask(taskId);
            }
            this.scheduledTasks.put(taskId, scheduleCronTask(cronTask));
        }
    }

    public void removeCronTask(String taskId) {
        ScheduledTask scheduledTask = this.scheduledTasks.remove(taskId);
        if (scheduledTask != null)
            scheduledTask.cancel();
    }

    private ScheduledTask scheduleCronTask(CronTask cronTask) {
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.future = this.taskScheduler.schedule(cronTask.getRunnable(), cronTask.getTrigger());
          return scheduledTask;
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
                String dataModel = interfaceInformation.getDataModel();
                String prepareExecuteSql = interfaceInformation.getPrepareExecuteSql();
                log.info("数据模型："+dataModel+"，"+"数据执行sql:" + prepareExecuteSql);
                if (!Strings.isNullOrEmpty(prepareExecuteSql) && !Strings.isNullOrEmpty(dataModel)){
                    baseService.executeSql(interfaceInformation);
                }else {
                    log.info("请检查数据模型和执行sql，是否缺失。" + interfaceInformation.toString());
                }
            }
        };
    }

    @Override
    public void destroy() {
        for (ScheduledTask task : this.scheduledTasks.values()) {
            task.cancel();
        }
        this.scheduledTasks.clear();
    }
}
