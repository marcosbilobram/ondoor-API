package br.com.fiap.Ondoor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

}
