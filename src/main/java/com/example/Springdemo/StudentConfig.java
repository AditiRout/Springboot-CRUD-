package com.example.Springdemo;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository) {
		return args->{

Student mariam=new Student(
					
					"Mariam",
					"dg@gmail.com",
					LocalDate.of(2000,10,10),
					1l,
					21);
Student alex=new Student(
							
							"alex",
							"al@gmail.com",
							LocalDate.of(2003,10,10),
							21);
repository.saveAll(List.of(mariam,alex));
		};
	}

}
