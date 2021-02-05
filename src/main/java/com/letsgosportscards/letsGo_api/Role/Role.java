package com.letsgosportscards.letsGo_api.Role;

import com.letsgosportscards.letsGo_api.User.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table
public class Role {
    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;

    @OneToMany(cascade= CascadeType.ALL)
    List<User> users = new ArrayList<>();

    public Role() {
    }

    public Role(String name) {
        this.id = id;
        this.name = name;
    }



}
