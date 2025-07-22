package com.thinkconstructive.restdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("🎉 Welcome to the Cloud Vendor REST API Demo powered by Spring Boot + MySQL!");
    }
}
