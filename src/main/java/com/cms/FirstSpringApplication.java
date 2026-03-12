package com.cms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(WordCounter wordCounter) {
        return args -> {
            System.out.println("Word count result:");
            wordCounter.createMapResult()
                    .forEach((fileName, count) -> System.out.println(fileName + " -> " + count));
        };
    }
}
