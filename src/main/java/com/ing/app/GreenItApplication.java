package com.ing.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GreenItApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenItApplication.class, args);
    }

}
