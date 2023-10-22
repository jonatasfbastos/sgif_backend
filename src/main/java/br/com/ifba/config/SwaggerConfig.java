package br.com.ifba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Configura um Docket do Swagger para gerar documentação de todos os endpoints da API.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * <p>
     * @return um Swagger Docket configurado para
     * documentar todos os endpoints da API.
     */
    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()) // Deixa todos os controllers visiveis na documentação.
                .paths(PathSelectors.any()) // Deixa todos os paths visiveis na documentação.
                .build();
    }
}
