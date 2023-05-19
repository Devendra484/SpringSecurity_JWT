package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		System.out.println("running");
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
