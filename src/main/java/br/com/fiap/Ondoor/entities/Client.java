package br.com.fiap.Ondoor.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client extends User {

    private String clientName;
    @Embedded
    private Address address;
    @Embedded
    private Phone phone;

    private Cart cart;
    private List<Order> orders;
    private List<Rating> ratings;

    public Client(){}

    public Client(Long id, String userName, String email,
                  String password, String clientName, Address address,
                  Phone phone, Cart cart, List<Order> orders, List<Rating> ratings) {
        super(id, userName, email, password);
        this.clientName = clientName;
        this.address = address;
        this.phone = phone;
        this.cart = cart;
        this.orders = orders;
        this.ratings = ratings;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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
}
