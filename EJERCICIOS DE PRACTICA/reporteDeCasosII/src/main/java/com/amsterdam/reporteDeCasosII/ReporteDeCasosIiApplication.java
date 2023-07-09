package com.amsterdam.reporteDeCasosII;

import com.amsterdam.reporteDeCasosII.dao.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ReporteDeCasosIiApplication {

	public static void main(String[] args) {
		Database.crearTablas();
		SpringApplication.run(ReporteDeCasosIiApplication.class, args);
	}

}
