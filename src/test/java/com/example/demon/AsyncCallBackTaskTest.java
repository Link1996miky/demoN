package com.example.demon;


import com.example.demon.config.AsyncCallBackTask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@SpringBootTest
public class AsyncCallBackTaskTest {

    @Resource
    private AsyncCallBackTask asyncCallBackTask;

    @Test
    public void asyncCallBackTaskTest() throws Exception {

        long start = System.currentTimeMillis();

        Future<String> task1=asyncCallBackTask.doTaskOneCallBack();
        Future<String> task2=asyncCallBackTask.doTaskTwoCallBack();
        Future<String> task3=asyncCallBackTask.doTaskThreeCallBack();
        while (!task1.isDone()||!task2.isDone()||!task3.isDone()){
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();
        System.out.println("任务总耗时：" + (end - start) + "ms");
    }
}
