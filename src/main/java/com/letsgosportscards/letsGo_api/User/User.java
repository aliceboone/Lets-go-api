package com.letsgosportscards.letsGo_api.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letsgosportscards.letsGo_api.Role.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Getter
@Setter
@ToString
@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1 )

    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String username;
    private String email;

    @JsonIgnore // prevents from serializing user
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="role_id", nullable = false)
    private Role role;

    public User() {
    }

    public User(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}


