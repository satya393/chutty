package com.chutty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.*"})
public class ChuttyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChuttyApplication.class, args);
	}

}
