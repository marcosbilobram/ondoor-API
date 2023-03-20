package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.*;

import java.util.Calendar;
import java.util.List;

public class OrderDTO {

    private Long id;

    private Double totalValue;

    private Calendar date;

    private List<Product> products;

    private Address deliveryAddress;

    private Client client;

    private Restaurant restaurant;

    private String status;

    public OrderDTO() {}

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.totalValue = order.getTotalValue();
        this.date = order.getDate();
        this.products = order.getProducts();
        this.deliveryAddress = order.getDeliveryAddress();
        this.client = order.getClient();
        this.restaurant = order.getRestaurant();
        this.status = order.getStatus();
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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