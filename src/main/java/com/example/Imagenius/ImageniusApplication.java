package com.example.Imagenius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.Imagenius") // Add the correct base package
public class ImageniusApplication {
	public static void main(String[] args) {
		SpringApplication.run(ImageniusApplication.class, args);
	}

}
