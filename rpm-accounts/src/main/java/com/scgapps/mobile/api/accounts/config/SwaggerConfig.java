package com.scgapps.mobile.api.accounts.config;

import com.scgapps.mobile.api.library.config.RPMSwaggerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends RPMSwaggerConfig {

    @Bean
    public Docket api() {
        return rpmDocket(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfo(
                "RPM-CRM ACCOUNTS & CONTACTS SERVICE",
                "Rest Api's for Accounts & Contacts microservice",
                "1.0",
                null,
                new Contact("RPM", "", ""),
                null,
                null);
    }
}
