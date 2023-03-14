package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @GetMapping(value = "/restaurant")
    public Restaurant show() { return new Restaurant();}
}
