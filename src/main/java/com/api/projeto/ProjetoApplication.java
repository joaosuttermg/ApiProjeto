package com.api.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger OpenApi", version = "1", description = "API PROJETO OpenApi"))
public class ProjetoApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
		
	}

}
