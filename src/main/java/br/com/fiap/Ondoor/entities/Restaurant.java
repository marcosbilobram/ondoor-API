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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String restaurantName;

    private String logo;

    @Embedded
    private Phone phone;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders;

    @OneToMany(mappedBy = "restaurant")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "restaurant")
    private List<Product> products;
}
