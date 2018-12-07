package com.github.hejun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
@EnableAutoConfiguration
public class Main {
    public static final String TIME_ZONE_ID = "GMT+8";

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(TIME_ZONE_ID));
        SpringApplication.run(Main.class, args);
    }
}
