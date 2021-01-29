package com.letsgosportscards.letsGo_api.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository
    extends JpaRepository<Category, Long> {

    @Query("SELECT s FROM Category s where s.name = ?1")
    Optional<Category> findCategoryByName(String name);
}
