//package com.letsgosportscards.letsGo_api.Product;
//
//import com.letsgosportscards.letsGo_api.Category.CategoryRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.*;
//import java.util.List;
//import com.letsgosportscards.letsGo_api.Category.Category;
//
//@Configuration
//public class ProductConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(
//            ProductRepository productRepository, CategoryRepository categoryRepository) {
//        return args -> {
//            Category category = categoryRepository.findCategoryByName("Baseball").get();
//            Product miguel = new Product(
//                    3L,
//                    "Miguel Cabrera",
//                    "Panini",
//                    "Panini Card",
//                    30.00,
//                    2019,
//                    "https://ibb.co/dWDzrqX",
//                    1,
//                    category
//            );
//
//            Product mike = new Product(
//                    "Mike Trout",
//                    "Panini",
//                    "LetsGo",
//                    30.00,
//                    1981,
//                    "https://ibb.co/t8BCM2T",
//                    2,
//                    category
//            );
//
//            productRepository.saveAll(
//                    List.of(mike, miguel)
//            );
//        };
//    }
//}