package com.letsgosportscards.letsGo_api.Product;

import javax.persistence.*;
import com.letsgosportscards.letsGo_api.Category.Category;

@Table
@Entity

public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )

    private Long id;
    private String name;
    private String brand;
    private String description;
    private double price;
    private int releaseYear;
    private String imageUrl;
    private int inventory;
    @ManyToOne
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

    public Product(String name,
                   String brand,
                   String description,
                   double price,
                   int releaseYear,
                   String imageUrl,
                   int inventory,
                   Category category) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.releaseYear = releaseYear;
        this.imageUrl = imageUrl;
        this.inventory = inventory;
        this.category = category;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", releaseYear=" + releaseYear +
                ", imageUrl='" + imageUrl + '\'' +
                ", inventory='" + inventory + '\'' +
                ", category=" + category +
                '}';
    }
}
