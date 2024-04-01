package com.bajaj.restaurant.models;


import jakarta.persistence.*;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;
    private  String price;
    private  String ingredients;
    private  String tag;
    private  String prepMins;
    private  String imageUrl;

    public Dish() {

    }

    public Dish(Long id, String name, String price, String ingredients, String tag, String prepMins, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.tag = tag;
        this.prepMins = prepMins;
        this.imageUrl = imageUrl;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPrepMins() {
        return prepMins;
    }

    public void setPrepMins(String prepMins) {
        this.prepMins = prepMins;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
