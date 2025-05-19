package com.pokemonmovethailand.pokemonmovebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokemonmovebackendApplication {

	public static void main(String[] args) {
		// อ่านจาก environment variables ของระบบโดยตรง
		System.setProperty("spring.datasource.url", System.getenv("SPRING_DATASOURCE_URL"));
		System.setProperty("spring.datasource.username", System.getenv("SPRING_DATASOURCE_USERNAME"));
		System.setProperty("spring.datasource.password", System.getenv("SPRING_DATASOURCE_PASSWORD"));

		SpringApplication.run(PokemonmovebackendApplication.class, args);
	}
}
