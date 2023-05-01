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
@Table(name = "tb_ond_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false)
    private String description;

    private String image;

    @Column(nullable = false)
    private Double pricePerUnit;

    @Column(nullable = false)
    private Integer quantity = 0;

    @ManyToMany(mappedBy = "productList", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Category> categories;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

}
