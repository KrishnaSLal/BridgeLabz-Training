package com.fundoonotes;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class FundooNotesAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                FundooNotesAppApplication.class,
                args
        );
    }
}