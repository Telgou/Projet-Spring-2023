package com.example.spring092023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Schedules;

@SpringBootApplication
@ComponentScan({"controller", "com.example.spring092023.entities","com.example.spring092023.services", "com.example.spring092023.repositories", "com.example.spring092023.configuration"})
@EnableScheduling()
public class Spring092023Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring092023Application.class, args);
    }

}
