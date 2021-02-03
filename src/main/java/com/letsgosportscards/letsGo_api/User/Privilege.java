package com.letsgosportscards.letsGo_api.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table

public class Privilege {
    @Id
    @SequenceGenerator(
            name = "privilege_sequence",
            sequenceName = "privilege_sequence",
            allocationSize = 1 )

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
    public Privilege() {
    }

    public Privilege(Long id,
                     String name,
                     Collection<Role> roles) {
        this.id = id;
        this.roles = roles;
    }

    public Privilege(String name,
                     Collection<Role> roles) {
        this.roles = roles;
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}
