package com.example.demon.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncCallBackTask extends AbstractTask{

    @Async
    public Future<String> doTaskOneCallBack() throws Exception {
        super.doTaskOne();
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public Future<String> doTaskTwoCallBack() throws Exception {
        super.doTaskTwo();
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> doTaskThreeCallBack() throws Exception {
        super.doTaskThree();
        return new AsyncResult<>("任务三完成");
    }
}
