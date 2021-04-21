package com.example.demon.controller;

import com.example.demon.timetask.QuartzBean;
import com.example.demon.timetask.QuartzUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/quartz/job/")
public class QuartzController {

    @Resource
    private Scheduler scheduler;


    @PostMapping("/create")
    public String createJob(@RequestBody QuartzBean quartzBean) throws SchedulerException, ClassNotFoundException {
        QuartzUtils.createScheduleJob(scheduler, quartzBean);
        return "已经创建任务";
    }


    @PostMapping("/pause")
    public String pauseJob(@RequestBody QuartzBean quartzBean) throws SchedulerException, ClassNotFoundException {
        QuartzUtils.pauseScheduleJob(scheduler, quartzBean.getJobName());
        return "已经暂停任务";
    }


    @PostMapping("/resume")
    public String resumeJob(@RequestBody QuartzBean quartzBean) throws SchedulerException, ClassNotFoundException {
        QuartzUtils.resumeScheduleJob(scheduler, quartzBean.getJobName());
        return "任务恢复运行";
    }


    @PostMapping("/delete")
    public String deleteJob(@RequestBody QuartzBean quartzBean) throws SchedulerException, ClassNotFoundException {
        QuartzUtils.deleteScheduleJob(scheduler, quartzBean.getJobName());
        return "已经删除任务";
    }


    @PostMapping("/update")
    public String updateJob(@RequestBody QuartzBean quartzBean) throws SchedulerException, ClassNotFoundException {
        QuartzUtils.updateScheduleJob(scheduler, quartzBean);
        return "任务更新完成";
    }

    @PostMapping("/run")
    public String runOnce(@RequestBody QuartzBean quartzBean) throws SchedulerException, ClassNotFoundException {
        QuartzUtils.runOnce(scheduler, quartzBean.getJobName());
        return "任务更新完成";
    }


}
