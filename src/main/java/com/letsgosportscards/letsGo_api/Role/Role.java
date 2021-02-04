package com.letsgosportscards.letsGo_api.Role;

import com.letsgosportscards.letsGo_api.User.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy="role", cascade = CascadeType.ALL)
    private List<UserRole> users;

    public Role() {
    }

    public Role(Long id, String name, List<UserRole> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserRole> getUsers() {
        return users;
    }

    public void setUsers(List<UserRole> users) {
        this.users = users;
    }
}
