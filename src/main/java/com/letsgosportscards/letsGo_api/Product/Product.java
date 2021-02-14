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
    private int releaseYear;
    private String brand;
    private String setName;;
    private String team;
    private int cardNumber;
    private String cardCondition;
    private int grade;
    private String gradedBy;
    private double currentValue;
    private double pricePaid;
    private double priceSold;
    private String notes;
    private String imageUrl1;
    private String imageUrl2;

    @ManyToOne
//    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @ManyToOne
//    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public Product() {
    }

    public Product(long id, String playerName,
                   int releaseYear,
                   String brand,
                   String setName,
                   String team,
                   int cardNumber,
                   String cardCondition,
                   int grade,
                   String gradedBy,
                   double currentValue,
                   double pricePaid,
                   double priceSold,
                   String notes,
                   String imageUrl1,
                   String imageUrl2,
                   Category category,
                   User user) {
        this.id = id;
        this.playerName = playerName;
        this.releaseYear = releaseYear;
        this.brand = brand;
        this.setName = setName;
        this.team = team;
        this.cardNumber = cardNumber;
        this.cardCondition = cardCondition;
        this.grade = grade;
        this.gradedBy = gradedBy;
        this.currentValue = currentValue;
        this.pricePaid = pricePaid;
        this.priceSold = priceSold;
        this.notes = notes;
        this.imageUrl1 = imageUrl1;
        this.imageUrl2 = imageUrl2;
        this.category = category;
        this.user = user;
    }
}

