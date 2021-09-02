package com.qs.demo.toolspringbootautoconfigure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

@SpringBootApplication
@ConditionalOnClass
public class ToolSpringbootAutoconfigureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolSpringbootAutoconfigureApplication.class, args);
    }

}
