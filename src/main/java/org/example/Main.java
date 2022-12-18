package org.example;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@RequiredArgsConstructor
@EnableJpaRepositories
@SpringBootApplication

public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);


    }
}