package com.prakritikishore.a2zEcomm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "a2zEcomm", version = "0.0.1", description = "Backend APIs"))
@SecurityScheme(name = "Authorization", scheme = "Bearer", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER)
public class A2zEcommApplication {

	public static void main(String[] args) {
		SpringApplication.run(A2zEcommApplication.class, args);
	}
}
