package com.thayna.finances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.thayna.finances.repository")
public class FinancesDApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinancesDApplication.class, args);
    }
}
