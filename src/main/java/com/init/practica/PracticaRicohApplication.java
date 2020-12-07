package com.init.practica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.init.practica.entities")
@SpringBootApplication(scanBasePackages={
		"com.init.practica", "com.init.practica.service"})
public class PracticaRicohApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaRicohApplication.class, args);
	}

}
