package com.qs.libs.qstool.samples;

import com.qs.libs.toolautoconfigure.logging.EnableOperationLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableOperationLog
public class QstoolSamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(QstoolSamplesApplication.class, args);
    }

}
