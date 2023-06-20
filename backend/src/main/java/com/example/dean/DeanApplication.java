package com.example.dean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeanApplication.class, args);
    }

}
