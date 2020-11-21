package com.wy.shop.service.quartz;

import groovy.util.IFileNameFinder;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author : WangYB
 * @time: 2020/11/21  16:27
 */
@Component
public class MyScheduler {

    public static final Integer COUNT=10;

    public void doScheduleTask() throws SchedulerException {
        //利用工厂创建一个任务调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        //构建一个job
        JobDetail job = JobBuilder.newJob(MyTask.class)
                .withIdentity("email", "jobGroup1")
                .build();
        //构建一个trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("emailTrigger", "triggerGroup1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(10)
                        .withRepeatCount(COUNT))
                .build();

//        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
//                .usingJobData("trigger1", "这是jobDetail1的trigger")
//                .startNow()//立即生效
//                .startAt(startDate)
//                .endAt(endDate)
//                .withSchedule(CronScheduleBuilder.cronSchedule("* 30 10 ? * 1/5 2018"))
//                .build();

        scheduler.scheduleJob(job,trigger);
        scheduler.start();
    }

}
