package com.letsgosportscards.letsGo_api.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository
        extends JpaRepository<Privilege, Integer> {
    @Query("SELECT p FROM Privilege p where p.name = ?1")
    Optional<Privilege> findByName(String name);
}
