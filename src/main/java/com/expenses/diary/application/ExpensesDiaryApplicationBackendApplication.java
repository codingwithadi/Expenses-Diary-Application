package com.expenses.diary.application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Expenses Diary Application APIs", version = "1.0.0"))
public class ExpensesDiaryApplicationBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensesDiaryApplicationBackendApplication.class, args);
	}

	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
}
