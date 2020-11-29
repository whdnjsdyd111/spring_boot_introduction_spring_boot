package com.example.spring_boot_introduction_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootIntroductionSpringBootApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SpringBootIntroductionSpringBootApplication.class, args);
        SpringApplication.run(SpringBootIntroductionSpringBootApplication.class, new String[] {"100"});
    }

}
