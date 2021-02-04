package com.letsgosportscards.letsGo_api.User;

import com.letsgosportscards.letsGo_api.Role.Role;
import com.letsgosportscards.letsGo_api.Role.UserRole;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1 )

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "user-sequence")

    private Long id;
    private String username;
    private String email;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<UserRole> role;

    public User() {
    }

    public User(Long id, String username, String email, List<UserRole> role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserRole> getRole() {
        return role;
    }

    public void setRole(List<UserRole> role) {
        this.role = role;
    }
}


