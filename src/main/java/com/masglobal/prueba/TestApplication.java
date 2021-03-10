package com.masglobal.prueba;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* Clase Para Iniciar la aplicación
*
* @author  David Luna
* @version 1.0
* @since   2021-03-04
*/
@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@EnableCaching
public class TestApplication {

    /**
     * Método de Inicio de la aplicación
     * @param args Con los parámetros de inicio
     */
    public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

    /**
     * Método para crear la documentación de Swagger
     * @return Docket con la documentación
     */
    @Bean
	public Docket api() { 
	    return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	}
	 
    /**
     * Método para la configuración del la documentación del API
     * @return Configuración de la documentación
     */
	private ApiInfo getApiInfo() {
	        return new ApiInfo(
	                "MASGLOBAL Open API",
	                "Para manejar el API Rest de Prueba",
	                "V1",
	                "urn:tos",
	                new Contact("MASGLOBAL Team", "https://www.masglobal.com", "contacto@masglobal.com"),
	                "CC BY-SA 3.0",
	                "https://creativecommons.org/licenses/by-sa/3.0/",
	                Collections.emptyList()
	        );
	    }	        
}
