package br.com.fiap.Ondoor.dto;

import br.com.fiap.Ondoor.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDTO {

    private Long id;

    private Double totalValue;

    private Calendar date;

    private List<Product> products;

    private Address deliveryAddress;

    private Client client;

    private Restaurant restaurant;

    private String status;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.totalValue = order.getTotalValue();
        this.date = order.getDate();
        this.products = order.getProducts();
        this.deliveryAddress = order.getDeliveryAddress();
        this.client = order.getClient();
        this.restaurant = order.getRestaurant();
        this.status = order.getStatus();
    }
}