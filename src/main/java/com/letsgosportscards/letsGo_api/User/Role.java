package com.letsgosportscards.letsGo_api.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1 )

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "role-sequence")

    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private User users;
    @ManyToMany
    private Privilege privilege;

    public Role() {
    }


}
