package com.example.pagedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PagedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagedemoApplication.class, args);
    }

}
