package tn.elife.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import tn.elife.spring.entities.Specialite;

@SpringBootApplication
@EnableScheduling
public class ExamenCliniqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenCliniqueApplication.class, args);
		
	}

}
