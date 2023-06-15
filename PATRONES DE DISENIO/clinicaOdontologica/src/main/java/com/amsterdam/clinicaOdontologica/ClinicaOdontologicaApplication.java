package com.amsterdam.clinicaOdontologica;

import com.amsterdam.clinicaOdontologica.dao.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {
		DB.crearTablas();
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
	}

}
