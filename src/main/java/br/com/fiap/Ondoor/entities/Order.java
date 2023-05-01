package br.com.fiap.Ondoor.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Priority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Calendar;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_ond_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double totalValue;

    @CreationTimestamp
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Calendar date;

    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Embedded
    private Address deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

}
