package br.com.fiap.Ondoor.dto;
import br.com.fiap.Ondoor.entities.Category;
import br.com.fiap.Ondoor.entities.Order;
import br.com.fiap.Ondoor.entities.Product;
import br.com.fiap.Ondoor.entities.Restaurant;
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
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private String image;

    private Double pricePerUnit;

    private Integer quantity = 0;

    private Category categoryDTO;

    private Restaurant restaurantDTO;

    private List<Order> orders;

    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        pricePerUnit = product.getPricePerUnit();
        quantity = product.getQuantity();
    }
}
