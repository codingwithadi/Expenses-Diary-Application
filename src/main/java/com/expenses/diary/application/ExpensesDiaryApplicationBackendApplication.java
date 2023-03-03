package com.expenses.diary.application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpensesDiaryApplicationBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensesDiaryApplicationBackendApplication.class, args);
	}

	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
}
