package com.xzy212306259.hello_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.xzy212306259.hello_server")
public class HelloServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloServerApplication.class, args);
	}

}