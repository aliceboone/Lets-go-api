package com.letsgosportscards.letsGo_api.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PrivilegeConfig {
    @Bean
    CommandLineRunner CommandLineRunner(
            PrivilegeRepository repository) {
        return args -> {
            Privilege admin = new Privilege(
                    1L,
                    "ADMIN"
            );

            Privilege user = new Privilege(
                    "USER"
            );
            repository.saveAll(
                    List.of(admin, user)
            );
        };
    }
}
