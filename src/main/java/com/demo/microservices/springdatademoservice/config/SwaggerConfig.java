package com.demo.microservices.springdatademoservice.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swagConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.demo.microservices.springdatademoservice.controller"))
				.build().apiInfo(getApiInfo());		
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("User Management REST API : Spring Boot + Spring Data",
				"Documentation for Spring data demo for 3rd party",
				"1.0",
				"Terms of service",
				new Contact("User Management", "https://google.com", "paritoshrakshit583@gmail.com"), 
				"MIT License",
				"https://opensource.org/licenses/MIT",
				new ArrayList<>());
	}
}
