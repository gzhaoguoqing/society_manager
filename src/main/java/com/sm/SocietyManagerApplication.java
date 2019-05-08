package com.sm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sm.dao")
public class SocietyManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocietyManagerApplication.class, args);
    }

}
