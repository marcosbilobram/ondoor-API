package br.com.fiap.Ondoor.entities;

import java.util.Calendar;
import java.util.List;

public class Order {

    private Integer id;
    private Double totalValue;
    private Calendar date;
    private List<Product> products;
    private Address deliveryAddress;
    private Client client;
    private Restaurant restaurant;
    private String status;

    public Order(Integer id, Double totalValue, Calendar date,
                 List<Product> products, Address deliveryAddress,
                 Client client, Restaurant restaurant, String status) {
        this.id = id;
        this.totalValue = totalValue;
        this.date = date;
        this.products = products;
        this.deliveryAddress = deliveryAddress;
        this.client = client;
        this.restaurant = restaurant;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}