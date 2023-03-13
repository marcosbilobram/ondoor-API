package br.com.fiap.Ondoor.entities;

import java.util.List;

//Embaddable
public class Cart {

    private Long id;
    private Client client;
    private List<Product> products;

    public Cart(){}

    public Cart(Long id, Client client, List<Product> products) {
        this.id = id;
        this.client = client;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getCustomer() {
        return client;
    }

    public void setCustomer(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
