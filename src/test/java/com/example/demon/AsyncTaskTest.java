package com.example.demon;


import com.example.demon.config.AsyncTask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class AsyncTaskTest {

    @Resource
    private AsyncTask asyncTask;

    @Test
    public void asyncTaskTest() throws Exception {

        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();

    }
}
