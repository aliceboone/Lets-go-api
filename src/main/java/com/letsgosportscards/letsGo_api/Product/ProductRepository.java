package com.letsgosportscards.letsGo_api.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface ProductRepository
    extends JpaRepository<Product, Long> {

    @Query("SELECT s FROM Product s where s.name = ?1")
    Optional<Product> findProductById(Long id);
}
