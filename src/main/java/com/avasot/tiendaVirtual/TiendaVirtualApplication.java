package com.avasot.tiendaVirtual;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TiendaVirtualApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TiendaVirtualApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TiendaVirtualApplication.class, args);
		LOGGER.info("TiendaVirtual is now running...");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
