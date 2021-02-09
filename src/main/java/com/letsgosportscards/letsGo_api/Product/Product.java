package com.letsgosportscards.letsGo_api.Product;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letsgosportscards.letsGo_api.Category.Category;
import com.letsgosportscards.letsGo_api.User.User;
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
    private String playerName;
    private String imageUrl;
    private String brand;
    private String setName;
    private String description;
    private int grade;
    private int inventory;
    private int card_number;
    private int releaseYear;
    private double price_paid;
    private double price_sold;
    private double current_value;

    @ManyToOne
//    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @ManyToOne
//    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public Product() {
    }

    public Product(String playerName, String imageUrl,
                   String brand,
                   String setName,
                   String description,
                   int grade,
                   int inventory,
                   int card_number,
                   int releaseYear,
                   double price_paid,
                   double price_sold,
                   double current_value) {
        this.playerName = playerName;
        this.imageUrl = imageUrl;
        this.brand = brand;
        this.setName = setName;
        this.description = description;
        this.grade = grade;
        this.inventory = inventory;
        this.card_number = card_number;
        this.releaseYear = releaseYear;
        this.price_paid = price_paid;
        this.price_sold = price_sold;
        this.current_value = current_value;
        this.category = category;
    }
}
