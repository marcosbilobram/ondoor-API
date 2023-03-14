package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Phone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {

    @GetMapping(value = "/phone")
    public Phone show() { return new Phone();}
}
