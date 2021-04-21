package com.example.demon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoNApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoNApplication.class, args);
    }

}
