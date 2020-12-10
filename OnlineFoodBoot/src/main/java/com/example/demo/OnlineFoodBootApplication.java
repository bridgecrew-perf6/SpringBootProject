package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo","com.example.model","com.example.repository","com.example.service",
		"com.example.controller"})
public class OnlineFoodBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodBootApplication.class, args);
	}

}
