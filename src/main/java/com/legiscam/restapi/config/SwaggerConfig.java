package com.legiscam.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
 
	@Bean
	public Docket detalheApi() {
 
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
 
		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.legiscam.restapi"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build());
 
		return docket;
	}
 
	private ApiInfoBuilder informacoesApi() {
 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder(); 
 
		apiInfoBuilder.title("API-Legiscam");
		apiInfoBuilder.description("API REST de sistema para câmara municipal.");
		apiInfoBuilder.version("1.0.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Copyright");
		apiInfoBuilder.license("Todos os direitos reservados");
		apiInfoBuilder.licenseUrl("http://www.legiscam.com.br");
		apiInfoBuilder.contact(this.contato());
 
		return apiInfoBuilder;
 
	}
	private Contact contato() {
 
		return new Contact(
				"Adilmar Júnior - Fábio Pereira - Marcos Fonseca",
				"http://www.legiscam.com.br", 
				"legiscam@gmail.com");
	}
}