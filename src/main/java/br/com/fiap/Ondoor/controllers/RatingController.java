package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

    @GetMapping(value = "/rating")
    public Rating show() { return new Rating();}
}
