package com.letsgosportscards.letsGo_api.Product;

import com.letsgosportscards.letsGo_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductRepository
    extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long Id);
}
