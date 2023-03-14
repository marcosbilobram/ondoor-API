package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @GetMapping(value = "/category")
    public Category show() { return new Category();}
}
