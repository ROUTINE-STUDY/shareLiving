package com.routinestudy.shareliving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShareLivingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareLivingApplication.class, args);
    }

}
