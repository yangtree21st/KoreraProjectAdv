package com.itlize.koreraprojectadv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.itlize.koreraprojectadv.*")
//@ComponentScan(basePackages = { "com.itlize.koreraprojectadv.*" })
//@EntityScan("com.itlize.koreraprojectadv.*")
public class KoreraProjectAdvApplication {

    public static void main(String[] args) {
        SpringApplication.run(KoreraProjectAdvApplication.class, args);
    }

}
