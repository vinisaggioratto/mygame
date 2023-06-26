package com.viniciusgs.mygame.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyGameApplication.class, args);

        System.out.println("Hello world!");
    }
}
