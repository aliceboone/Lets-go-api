package com.letsgosportscards.letsGo_api;

import com.letsgosportscards.letsGo_api.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class LetsGoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetsGoApiApplication.class, args);
	}
}
