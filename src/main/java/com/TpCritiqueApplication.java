package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"nba","player"})
public class TpCritiqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpCritiqueApplication.class, args);
	}

}
