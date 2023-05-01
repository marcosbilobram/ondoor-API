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
@Table(name = "tb_ond_client")
public class Client extends User {

    @Column(length = 25, nullable = false)
    private String clientName;

    @Embedded
    private Address address;

    @Embedded
    private Phone phone;

    @Embedded
    private Cart cart;

    @OneToMany(mappedBy = "client", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private List<Order> orders;

    @OneToMany(mappedBy = "client", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private List<Rating> ratings;
}
