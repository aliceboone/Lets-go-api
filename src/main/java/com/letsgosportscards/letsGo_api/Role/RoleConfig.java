//package com.letsgosportscards.letsGo_api.Role;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//@Configuration
//public class RoleConfig {
//    @Bean
//    CommandLineRunner CommandLineRunner(
//            RoleRepository repository) {
//        return args -> {
//           Role admin = new Role(
//                   1L,
//                   "admin"
//            );
//            Role vendor = new Role(
//                    "Vendor"
//            );
//            Role customer = new Role(
//                    "Customer"
//            );
//            repository.saveAll(
//                    List.of(admin,vendor, customer)
//            );
//        };
//    }
//}
