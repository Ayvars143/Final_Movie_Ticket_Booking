package com.onlinemoviticket.booking.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Movie Service API")
                        .version("1.0")
                        .description("API documentation for Movie Service")
                        .contact(new Contact()
                                .name("Support Team")
                                .email("vinay.kowkoori@gmail.com")
                                .url("https://onlinemoviebooking.com")));
    }
}
