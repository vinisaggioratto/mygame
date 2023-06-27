package com.viniciusgs.mygame;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyGameApplication.class, args);

        System.out.println("Hello world!");
        System.out.println("Teste de conexao com o github");
    }
}
