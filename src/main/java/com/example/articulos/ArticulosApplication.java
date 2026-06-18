package com.example.articulos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "API de Artículos - Proyecto Final", version = "1.0", description = "CRUD para la gestión de artículos y categorías"))
@SpringBootApplication
public class ArticulosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticulosApplication.class, args);
	}

}
