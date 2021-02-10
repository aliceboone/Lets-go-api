

package com.letsgosportscards.letsGo_api.Category;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letsgosportscards.letsGo_api.Product.Product;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonIgnore // prevents from serializing user
    @OneToMany(mappedBy = "category")
    List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }
}
