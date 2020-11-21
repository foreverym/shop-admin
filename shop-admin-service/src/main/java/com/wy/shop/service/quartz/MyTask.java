package com.wy.shop.service.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author : WangYB
 * @time: 2020/11/21  16:31
 */
public class MyTask implements Job {

    public void sendEmail() {
        System.out.println("发送了一封邮件");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        sendEmail();
    }


}
