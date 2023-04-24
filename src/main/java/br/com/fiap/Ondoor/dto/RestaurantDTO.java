package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Builder
public class RestaurantDTO {

    private Long id;

    private String restaurantName;

    private String logo;

    private Phone phone;

    private Address address;

    private List<Order> orders;

    private List<Rating> ratings;

    private List<Product> products;

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
}