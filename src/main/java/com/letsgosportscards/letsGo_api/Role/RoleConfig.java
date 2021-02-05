//package com.letsgosportscards.letsGo_api.Role;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//
//import java.util.List;
//
//public class RoleConfig {
//    @Bean
//    CommandLineRunner categoryCommandLineRunner(
//            RoleRepository repository) {
//        return args -> {
//           Role admin = new Role(
//                    "Admin"
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
