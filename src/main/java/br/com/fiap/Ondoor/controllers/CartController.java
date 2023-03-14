package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Cart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @GetMapping(value = "/cart")
    public Cart show() { return new Cart();}

}
