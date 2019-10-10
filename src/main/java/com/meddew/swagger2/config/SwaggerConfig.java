package com.meddew.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //To be able to see each documented route in the swagger limited to the scope of my API
                .apis(RequestHandlerSelectors.basePackage("com.meddew"))
                //To be able to see each documented route in the swagger limited to the scope of my API + Spring
                //.apis(RequestHandlerSelectors.any())
                //To see the swagger documentation of any route of the api
                //.paths(PathSelectors.any())
                //To see the swagger documentation limited to base package given : see the StudentController
                .paths(PathSelectors.ant("/school/*"))
                .build();
    }
}
