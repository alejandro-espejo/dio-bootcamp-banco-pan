package com.digitalinnovation.labpadroesprojetospring.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

//	@Bean
//	public OpenAPI openAPI() {
//		return new OpenAPI()
//				.info(new Info().title("Projeto API").description("Spring sample application").version("v0.0.1")
//						.license(new License().name("Apache 2.0").url("http://springdoc.org")))
//				.externalDocs(new ExternalDocumentation().description("Padrões Projeto Spring"));
//	}
	
	  @Bean
	  public GroupedOpenApi publicApi() {
	      return GroupedOpenApi.builder()
	              .group("API Pública")
	              .pathsToMatch("/**")
	              .build();
	  }
//	  @Bean
//	  public GroupedOpenApi adminApi() {
//	      return GroupedOpenApi.builder()
//	              .group("springshop-admin")
//	              .pathsToMatch("/admin/**")
//	              .build();
//	  }
}
