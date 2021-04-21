package com.example.demon.config;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class ScheduledJobs {

    @Scheduled(fixedDelay = 5000)
    public void fixedDelayJob() throws InterruptedException{
        System.out.println("fixedDelay start："+new Date());
        Thread.sleep(10*1000);
        System.out.println("fixedDelay end："+new Date());
    }


    @Scheduled(fixedRate = 5000)
    public void fixedRateJob() throws InterruptedException{
        System.out.println("fixedRate start："+new Date());
        Thread.sleep(5*1000);
        System.out.println("fixedRate end："+new Date());
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void cronJob() {
        System.out.println("=========================== -> cron"+new Date());
    }


}
