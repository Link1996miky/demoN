package com.example.demon.timetask;

import lombok.Data;

@Data
public class QuartzBean {

    //任务id
    private String id;

    //任务名称
    private String jobName;

    //任务执行类
    private String jobClass;

    //任务状态  启动or暂停
    private Integer status;
    //任务运行时间的表达式
    private String cronExpression;

}
