package br.com.fiap.Ondoor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Restaurant extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String restaurantName;
    private String logo;
    private Phone phone;
    private Address address;
    private List<Order> orders;
    private List<Rating> ratings;
    private List<Product> products;

    public Restaurant(){}

    public Restaurant(Long id, String userName, String email, String password,
                      String restaurantName, String logo, Phone phone, Address address,
                      List<Order> orders, List<Rating> ratings, List<Product> products) {
        super(id, userName, email, password);
        this.restaurantName = restaurantName;
        this.logo = logo;
        this.phone = phone;
        this.address = address;
        this.orders = orders;
        this.ratings = ratings;
        this.products = products;
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
