package com.backbase.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Web Application
 *
 * @author Rafael Aleman
 */
@SpringBootApplication
public class WebApplication {

    /**
     * Main method that runs Spring Boot.
     *
     * @param args the usual command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
