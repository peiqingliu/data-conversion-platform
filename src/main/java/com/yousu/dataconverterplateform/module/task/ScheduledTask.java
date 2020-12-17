package com.yousu.dataconverterplateform.module.task;

import java.util.concurrent.ScheduledFuture;

/**
 * @Author peiqing Liu
 * @Date 2020/4/6 21:11
 * @Version 1.0
 */
public final class ScheduledTask {

    volatile ScheduledFuture future;

    /**
     * 取消定时任务
     */
    public void cancel() {
        ScheduledFuture future = this.future;
        if (future != null) {
            future.cancel(true);
        }
    }

}
