package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.*;

import java.util.List;

public class ClientDTO extends User {

    private String clientName;
    private Address address;
    private Phone phone;
    private Cart cart;
    private List<Order> orders;
    private List<Rating> ratings;

    public ClientDTO() {}

    public ClientDTO(Client client) {
        this.clientName = client.getClientName();
        this.address = client.getAddress();
        this.phone = client.getPhone();
        this.cart = client.getCart();
        this.orders = client.getOrders();
        this.ratings = client.getRatings();
        this.address = client.getAddress();
    }

    // getters and setters

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