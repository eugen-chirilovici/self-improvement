package com.selfimprovement.app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class OpenAPIConfig {

    @Value("${api.common.version}")
    String apiVersion;
    @Value("${api.common.title}")
    String apiTitle;
    @Value("${api.common.description}")
    String apiDescription;
    @Value("${api.common.termsOfServiceUrl}")
    String apiTermsOfServiceUrl;
    @Value("${api.common.license}")
    String apiLicense;
    @Value("${api.common.licenseUrl}")
    String apiLicenseUrl;
    @Value("${api.common.contact.name}")
    String apiContactName;
    @Value("${api.common.contact.url}")
    String apiContactUrl;
    @Value("${api.common.contact.email}")
    String apiContactEmail;

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .version(apiVersion)
                        .title(apiTitle)
                        .description(apiDescription)
                        .termsOfService(apiTermsOfServiceUrl)
                        .license(new License().name(apiLicense).url(apiLicenseUrl))
                );
    }
}
