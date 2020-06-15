package com.scgapps.mobile.api.accounts;

import com.scgapps.mobile.api.library.config.DatabaseConfigurations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableConfigurationProperties(DatabaseConfigurations.class)
@ComponentScan({"com.scgapps.mobile.api.accounts","com.scgapps.mobile.api.library.config"})
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }
}
