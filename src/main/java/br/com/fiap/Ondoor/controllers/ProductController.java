package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping(value = "/product")
    public Product show() { return new Product();}
}
