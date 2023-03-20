package br.com.fiap.Ondoor.dto;
import br.com.fiap.Ondoor.entities.Category;
import br.com.fiap.Ondoor.entities.Order;
import br.com.fiap.Ondoor.entities.Product;
import br.com.fiap.Ondoor.entities.Restaurant;
import jakarta.persistence.*;

import java.util.List;

public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private String image;

    private Double pricePerUnit;

    private Integer quantity = 0;

    private Category categoryDTO;

    private Restaurant restaurantDTO;

    private List<Order> orders;

    public ProductDTO() {}

    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        pricePerUnit = product.getPricePerUnit();
        quantity = product.getQuantity();
    }

    // getters and setters

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

    public Category getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(Category categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public Restaurant getRestaurantDTO() {
        return restaurantDTO;
    }

    public void setRestaurantDTO(Restaurant restaurantDTO) {
        this.restaurantDTO = restaurantDTO;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
