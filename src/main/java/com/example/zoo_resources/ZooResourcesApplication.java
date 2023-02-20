package com.example.zoo_resources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ZooResourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZooResourcesApplication.class, args);
    }

}
