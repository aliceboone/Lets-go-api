package com.letsgosportscards.letsGo_api.Product;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letsgosportscards.letsGo_api.Category.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity
@Getter
@Setter
@ToString
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String brand;
    private String description;
    private double price;
    private int releaseYear;
    private String imageUrl;
    private int inventory;

    @JsonIgnore // prevents from serializing user
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    public Product() {
    }

    public Product(Long id,
                   String name,
                   String brand,
                   String description,
                   double price,
                   int releaseYear,
                   String imageUrl,
                   int inventory,
                   Category category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.releaseYear = releaseYear;
        this.imageUrl = imageUrl;
        this.inventory = inventory;
        this.category = category;
    }

    public Product(String name, String brand,
                   String description,
                   double price, int releaseYear,
                   String imageUrl, int inventory, Category category) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.releaseYear = releaseYear;
        this.imageUrl = imageUrl;
        this.inventory = inventory;
        this.category = category;
    }
}
