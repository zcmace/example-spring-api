package com.prophet.prophetapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.prophet.prophetapi.*"})
public class ProphetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProphetApiApplication.class, args);
		
	}

}
