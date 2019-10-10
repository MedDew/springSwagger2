package com.meddew.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){

        List<ResponseMessage> responseMessages = Arrays.asList(
                        new ResponseMessageBuilder()
                        .code(500)
                        .message("Internal Server Error")
                        .responseModel(new ModelRef("Error 500"))
                        .build(),
                        new ResponseMessageBuilder()
                        .code(403)
                        .message("Forbidden!!")
                        .build()
        );

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
                .build()
                .apiInfo(getApiDetails())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                    new ArrayList<ResponseMessage>(responseMessages)
                );
    }

    private ApiInfo getApiDetails(){
        return new ApiInfo(
          "Students API",
          "Basic CRUD for managing Students",
          "1.0",
          "For Teaching purpose",
          new Contact("MedDew", "http://www.MedDew.ca", "m.dew@gmail.com"),
          "API Licence",
          "http://www.MedDew.ca",
           Collections.emptyList()
        );
    }
}
