package com.example.demon.timetask;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzSimpleConfig {
//    //指定定时任务的类
//    @Bean
//    public JobDetail updateTaskDetail() {
//        return JobBuilder.newJob(QuartzSimpleTask.class).withIdentity("QuartzSimpleTask").storeDurably()
//                .build();
//    }
//
//    //任务触发器
//    @Bean
//    public Trigger updateTaskTigger() {
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
//        return TriggerBuilder.newTrigger()
//                .forJob("updateTaskDetail")
//                .withIdentity("QuartzSimpleTask")
//                .withSchedule(scheduleBuilder)
//                .build();
//
//    }
}
