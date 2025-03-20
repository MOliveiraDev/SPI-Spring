package com.ssf.generate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenerateApplication {

	public static void main(String[] args) {
		// Carregar a variável do .env
		Dotenv dotenv = Dotenv.load();
		SpringApplication.run(GenerateApplication.class, args);
	}

}
