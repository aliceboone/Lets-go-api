package com.letsgosportscards.letsGo_api.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

        @Query("SELECT r FROM Role r where r.name = ?1")
        Optional<Role> findByName(String name);
}
