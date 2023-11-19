package com.example.spring092023.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI openApiInformation(){
        Contact contact = new Contact().email("test").name("Ahmed Gam");
        Info info = new Info().contact(contact).description("Projet Foyer Spring Boot")
                .summary("management of dorm")
                .title("FOYER")
                .license(new License().name("Apache").url("test"));
        return new OpenAPI().info(info);
    }

    @Bean
    public GroupedOpenApi UNIPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only university Management API")
                .pathsToMatch("/universites/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi undocumentedPublicApi() {
        return GroupedOpenApi.builder()
                .group("still undocumented")
                .pathsToExclude("/universites/**")
                .build();
    }
}
