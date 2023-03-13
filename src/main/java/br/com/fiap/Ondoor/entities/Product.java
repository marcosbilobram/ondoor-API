package br.com.fiap.Ondoor.entities;

import java.util.List;

public class Product {

    private Long id;
    private String name;
    private String description;
    private String image;
    private Double pricePerUnit;
    private Integer quantity = 0;

    private Category category;
    private Restaurant restaurant;
    private List<Order> orders;

    public Product(){}

    public Product(Long id, String name, String description, String image,
                   Double pricePerUnit, Integer quantity, Category category,
                   Restaurant restaurant, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.category = category;
        this.restaurant = restaurant;
        this.orders = orders;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
