package com.letsgosportscards.letsGo_api.Product;

import javax.persistence.*;
import com.letsgosportscards.letsGo_api.Category.Category;
import com.letsgosportscards.letsGo_api.model.User;
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

    private long id;
    private String playerName;
    private String imageUrl1;
    private String imageUrl2;
    private String brand;
    private String notes;
    private String setName;;
    private String team;
    private String cardCondition;
    private String description;
    private int grade;
    private int cardNumber;
    private int releaseYear;
    private double pricePaid;
    private double priceSold;
    private double currentValue;


    @ManyToOne
//    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @ManyToOne
//    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public Product() {
    }

    public Product(String playerName,
                   String imageUrl1,
                   String imageUrl2,
                   String brand,
                   String notes,
                   String setName,
                   String team,
                   String cardCondition,
                   String description,
                   int grade,
                   int cardNumber,
                   int releaseYear,
                   double pricePaid,
                   double priceSold,
                   double currentValue,
                   Category category,
                   User user) {
        this.playerName = playerName;
        this.imageUrl1 = imageUrl1;
        this.imageUrl2 = imageUrl2;
        this.brand = brand;
        this.notes = notes;
        this.setName = setName;
        this.team = team;
        this.cardCondition = cardCondition;
        this.description = description;
        this.grade = grade;
        this.cardNumber = cardNumber;
        this.releaseYear = releaseYear;
        this.pricePaid = pricePaid;
        this.priceSold = priceSold;
        this.currentValue = currentValue;
        this.category = category;
        this.user = user;
    }
}

