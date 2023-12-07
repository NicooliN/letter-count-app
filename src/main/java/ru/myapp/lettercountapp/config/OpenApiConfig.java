package ru.charcount.testcount.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    //http://localhost:9090/api/rest/swagger-ui/index.html
    @Bean
    public OpenAPI TestCount() {
        return new OpenAPI()
              .info(new Info()
                          .title("Char Count")
                          .description("Сервис, подсчета символов в слове")
                          .version("v0.1")
                          .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                          .contact(new Contact().name("NikulinPA")
                                         .email("niko91@tpu.ru")
                                         .url(""))
                   );
    }
}
