package com.letsgosportscards.letsGo_api.model;

import com.letsgosportscards.letsGo_api.Product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user",
        uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Email
    @Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    private String email; // Must be Unique

    private String imageUrl;

    @Column(nullable = false)
    private Boolean emailVerified = false;

    @JsonIgnore
    private String password;
    //
    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private AuthProvider provider = AuthProvider.local; // todo need to remove equal later

    private String providerId;

//    @OneToMany(targetEntity= Product.class,
//    orphanRemoval = true,
//    cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
//    fetch = FetchType.LAZY
//    )

    @JsonIgnore // prevents from serializing user
    @OneToMany(mappedBy = "user")
    List<Product> products = new ArrayList<>();

    public User() {
    }

    public User( String name, String email) {
        this.name = name;
        this.email = email;
    }


}


