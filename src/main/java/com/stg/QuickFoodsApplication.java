package com.stg;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SwaggerDefinition
@SpringBootApplication
public class QuickFoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickFoodsApplication.class, args);

	}
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
