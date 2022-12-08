package com.cydeo.lab08rest;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Lab08RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab08RestApplication.class, args);
    }
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }


    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(
                        new Info().title("Ecommerce Application OpenAPI").version("v1").description("Ecommerce Application API Documentation"))
                .servers(List.of(new Server().url("https://cydeo.com").description("Dev Environment")));
    }

}
