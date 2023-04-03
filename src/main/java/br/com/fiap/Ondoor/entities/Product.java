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
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;
    @Column(nullable = false)
    private String description;
    private String image;
    @Column(scale = 3, precision = 2, nullable = false)
    private Double pricePerUnit;
    @Column(nullable = false)
    private Integer quantity = 0;

    @ManyToMany
    private List<Category> category;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToMany
    private List<Order> orders;

}
