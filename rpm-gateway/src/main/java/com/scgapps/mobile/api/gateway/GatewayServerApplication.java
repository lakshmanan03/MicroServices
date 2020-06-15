package com.scgapps.mobile.api.gateway;

import com.scgapps.mobile.api.gateway.config.ErrorFilter;
import com.scgapps.mobile.api.gateway.config.PreFilter;
import com.scgapps.mobile.api.gateway.config.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.scgapps.mobile.api.gateway.config.PostFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { RabbitAutoConfiguration.class })
@EnableZuulProxy
@EnableRedisRepositories("com.scgapps.mobile.api.gateway")
@ComponentScan("com.scgapps.mobile.api.gateway")
@EnableEurekaClient
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}
	


}
