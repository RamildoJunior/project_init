package br.com.rd.payments.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("br.com.payments"))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(apiInfo());
        }

        private ApiInfo apiInfo() {

            ApiInfo apiInfo = new ApiInfoBuilder()
                    .title("MS-Order")
                    .description("Essa é uma API desenvolvida para Compass.Uol e RaiaDrogasil.")
                    .license("Apache License Version 2.0")
                    .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                    .termsOfServiceUrl("/service.html")
                    .version("1.1.0")
                    .contact(new Contact("Ramildo Pereira da Silva Junior", "https://github.com/RamildoJunior", "ramildo.silva@compasso.com.br"))
                    .build();

            return apiInfo;
        }
    }