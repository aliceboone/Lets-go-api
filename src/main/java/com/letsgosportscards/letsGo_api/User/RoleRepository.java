package com.letsgosportscards.letsGo_api.User;

import com.letsgosportscards.letsGo_api.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {
    @Query("SELECT r FROM Role r where r.name = ?1")
    Optional<Role> findByName(String name);
}
