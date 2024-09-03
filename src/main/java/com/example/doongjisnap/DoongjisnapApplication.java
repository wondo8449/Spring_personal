package com.example.doongjisnap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAspectJAutoProxy
@SpringBootApplication
@EnableScheduling
public class DoongjisnapApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoongjisnapApplication.class, args);
    }

}
