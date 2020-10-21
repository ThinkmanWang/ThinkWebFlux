package com.thinkman.thinkwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class ThinkwebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThinkwebfluxApplication.class, args);
    }

}
