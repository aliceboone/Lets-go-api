package com.letsgosportscards.letsGo_api.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner CommandLineRunner(
            UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            Role role =roleRepository.findByName("Admin").get();
            User aliceB = new User(
                    1,
                    "AliceB",
                    "aliceb@letsgo.com",
                    true,
                    role
            );
            User annaK = new User(
                    "AnnaK",
                    "annak@gmail.com",
                    true,
                    role
            );

            userRepository.saveAll(
                    List.of(aliceB, annaK)
            );
        };
    }
}
