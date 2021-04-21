package com.example.demon.config;

import java.util.Random;

public abstract class AbstractTask {

    public static Random random = new Random();

    public void doTaskOne() throws Exception {
        System.out.println("任务一开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务一执行结束，耗时：" + (end - start) + "ms");
    }
    public void doTaskTwo() throws Exception {
        System.out.println("任务二开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务二执行结束，耗时：" + (end - start) + "ms");
    }
    public void doTaskThree() throws Exception {
        System.out.println("任务三开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务三执行结束，耗时：" + (end - start) + "ms");
    }
}
