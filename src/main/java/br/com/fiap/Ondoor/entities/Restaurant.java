package br.com.fiap.Ondoor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Builder
@Table(name = "tb_ond_restaurant")
public class Restaurant extends User{

    private String restaurantName;

    private String logo;

    @Embedded
    private Phone phone;

    @Embedded
    private Address address;

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Order> orders;

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Rating> ratings;

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Product> products;
}
