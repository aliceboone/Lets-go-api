package com.letsgosportscards.letsGo_api.Category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class CategoryConfig {
    @Bean
    CommandLineRunner categoryCommandLineRunner(
            CategoryRepository repository) {
        return args -> {
            Category baseball = new Category(
                    1L,
                    "Baseball"
            );
            Category basketball = new Category(
                    "Basketball"
            );
            Category football = new Category(
                    "Football"
            );
            repository.saveAll(
                    List.of(baseball, basketball, football)
            );
        };
    }
}
