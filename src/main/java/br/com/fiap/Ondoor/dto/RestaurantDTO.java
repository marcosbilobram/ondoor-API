package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.*;
import jakarta.persistence.*;

import java.util.List;

public class RestaurantDTO {

    private Long id;

    private String restaurantName;

    private String logo;

    private Phone phone;

    private Address address;

    private List<Order> orders;

    private List<Rating> ratings;

    private List<Product> products;

    public RestaurantDTO() {}

    public RestaurantDTO(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.restaurantName = restaurant.getRestaurantName();
        this.logo = restaurant.getLogo();
        this.phone = restaurant.getPhone();
        this.address = restaurant.getAddress();
        this.orders = restaurant.getOrders();
        this.ratings = restaurant.getRatings();
        this.products = restaurant.getProducts();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}