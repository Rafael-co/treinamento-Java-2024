package com.rco.contactControl.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(
						new Components().addSecuritySchemes("bearerAuth",
								new SecurityScheme().type(SecurityScheme.Type.HTTP)
									.scheme("bearer").bearerFormat("JWT")
								)
						)
				.info(
						new Info()
							.title("App de cadastro de Pessoas e seus Contatos")
							.description("Este app faz cadastro e controle de Pessoas " +
							             " bem como o cadastro e controle dos Contatos destas pessoas.")
							.contact(new Contact()
										.name("Rafael Camilo")
										.email("rafael.camilo21@outlookc.com")
										.url("http://localhost:8081")
									)
							.version("Versão 0.0.1-SNAPSHOT")
						)
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
				
	}
	
}
