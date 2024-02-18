package com.belkacem.todolistwebservice;

import com.belkacem.todolistservice.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;


@SpringBootApplication(scanBasePackages = "com.belkacem")
@Import(ServiceConfig.class)
public class TodoListWsApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoListWsApplication.class, args);
    }

}
