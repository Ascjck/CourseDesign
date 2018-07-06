package com.software.logout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LogoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogoutApplication.class, args);
    }
}
