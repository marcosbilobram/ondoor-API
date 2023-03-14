package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping(value = "/order")
    public Order show() { return new Order();}
}
