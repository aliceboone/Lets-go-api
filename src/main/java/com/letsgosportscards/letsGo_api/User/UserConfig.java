package com.letsgosportscards.letsGo_api.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner CommandLineRunner(
            UserRepository userRepository) {
        return args -> {
            User adminUser = new User(
                    1L,
                    "Admin",
                    "admin@letsgo.com",
                    "secretKey",
                    "admin"
            );
            userRepository.saveAll(
                    List.of(adminUser)
            );
        };
    }
}
