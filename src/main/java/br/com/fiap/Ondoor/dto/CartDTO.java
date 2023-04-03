package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.Cart;
import br.com.fiap.Ondoor.entities.Client;
import br.com.fiap.Ondoor.entities.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CartDTO {

    private Long id;
    private Client client;
    private List<Product> products;

    public CartDTO(Cart cart){
        id = getId();
        client = getClient();
        products = getProducts();
    }
}