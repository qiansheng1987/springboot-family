package com.qs.libs.qstool.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class QstoolSamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(QstoolSamplesApplication.class, args);
    }

}
