package com.example.command;

import com.example.command.constants.AlarmCommandConstants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * main class.
 */
@SpringBootApplication
@ComponentScan({ AlarmCommandConstants.BASE_PACKAGE })
public class AlarmCommandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlarmCommandServiceApplication.class, args);
    }
}
