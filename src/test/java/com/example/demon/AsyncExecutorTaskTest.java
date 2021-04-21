package com.example.demon;


import com.example.demon.config.AsyncCallBackTask;
import com.example.demon.config.AsyncExecutorTask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@SpringBootTest
public class AsyncExecutorTaskTest {

    @Resource
    private AsyncExecutorTask asyncExecutorTask;

    @Test
    public void asyncCallBackTaskTest() throws Exception {

        long start = System.currentTimeMillis();

        Future<String> task1=asyncExecutorTask.doTaskOneCallBack();
        Future<String> task2=asyncExecutorTask.doTaskTwoCallBack();
        Future<String> task3=asyncExecutorTask.doTaskThreeCallBack();
        while (!task1.isDone()||!task2.isDone()||!task3.isDone()){
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();
        System.out.println("任务总耗时：" + (end - start) + "ms");
    }
}
