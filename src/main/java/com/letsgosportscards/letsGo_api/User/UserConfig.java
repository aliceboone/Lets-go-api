package com.letsgosportscards.letsGo_api.User;

import com.letsgosportscards.letsGo_api.Role.Role;
import com.letsgosportscards.letsGo_api.Role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner CommandLineRunner(
            UserRepository  userRepository, RoleRepository roleRepository) {
        return args -> {
            Role role = roleRepository.findByName("admin").get();
            User adminUser = new User(
                    1L,
                    "AgCraw",
                    "admin@letsgo.com",
                     role
            );
            userRepository.saveAll(
                    List.of(adminUser)
            );
        };
    }
}
