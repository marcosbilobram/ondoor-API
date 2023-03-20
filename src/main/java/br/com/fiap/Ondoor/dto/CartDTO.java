package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.Cart;
import br.com.fiap.Ondoor.entities.Client;
import br.com.fiap.Ondoor.entities.Product;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class CartDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @ManyToMany
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public CartDTO() {}

    public CartDTO(Cart cart){
        id = getId();
        client = getClient();
        products = getProducts();
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}