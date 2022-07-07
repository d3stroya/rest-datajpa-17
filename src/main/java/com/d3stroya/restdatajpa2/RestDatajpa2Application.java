package com.d3stroya.restdatajpa2;

import com.d3stroya.restdatajpa2.entities.Laptop;
import com.d3stroya.restdatajpa2.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestDatajpa2Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(RestDatajpa2Application.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		// Crear ordenadores
		Laptop mac = new Laptop(null, 2018, 16, 100, true);
		Laptop vaio = new Laptop(null, 2016, 16, 512, true);

		// Guardar ordenadores
		laptopRepository.save(mac);
		laptopRepository.save(vaio);
	}

}
