package com.example.demon.timetask;

import org.quartz.*;

public class QuartzUtils {

    /**
     * 创建定时任务 ，默认启动状态
     *
     * @param scheduler  调度器
     * @param quartzBean 定时任务信息类
     * @throws ClassNotFoundException
     * @throws SchedulerException
     */
    public static void createScheduleJob(Scheduler scheduler, QuartzBean quartzBean) throws ClassNotFoundException, SchedulerException {
        //获取到定时任务的执行类
        //定时任务需要job类的具体实现，QuartzBean是job的抽象类
        Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(quartzBean.getJobClass());
        //构造定时任务类信息
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(quartzBean.getJobName()).build();
        //设置定时任务的执行方式
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzBean.getCronExpression());
        //构建触发器
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(quartzBean.getJobName()).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 暂停定时任务
     *
     * @param scheduler 调度器
     * @param jobName   任务名称
     * @throws SchedulerException
     */
    public static void pauseScheduleJob(Scheduler scheduler, String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName);
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复定时任务
     *
     * @param scheduler 调度器
     * @param jobName   任务名称
     * @throws SchedulerException
     */
    public static void resumeScheduleJob(Scheduler scheduler, String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName);
        scheduler.resumeJob(jobKey);
    }

    /**
     * 立即运行定时任务
     *
     * @param scheduler 调度器
     * @param jobName   任务名称
     * @throws SchedulerException
     */
    public static void runOnce(Scheduler scheduler, String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName);
        scheduler.triggerJob(jobKey);
    }

    /**
     * 更新定时任务
     *
     * @param scheduler  调度器
     * @param quartzBean 任务名称
     * @throws SchedulerException
     */
    public static void updateScheduleJob(Scheduler scheduler, QuartzBean quartzBean) throws SchedulerException {
        //获取对应任务的触发器
        TriggerKey triggerKey = TriggerKey.triggerKey(quartzBean.getJobName());
        //设置定时任务的执行方式
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzBean.getCronExpression());
        //重新构建触发器
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        scheduler.rescheduleJob(triggerKey, trigger);
    }

    /**
     * 删除运行定时任务
     *
     * @param scheduler 调度器
     * @param jobName   任务名称
     * @throws SchedulerException
     */
    public static void deleteScheduleJob(Scheduler scheduler, String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName);
        scheduler.deleteJob(jobKey);
    }


}
