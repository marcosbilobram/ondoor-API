package br.com.fiap.Ondoor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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
}
