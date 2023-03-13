package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @GetMapping(value = "/address")
    public Address show(){
        return new Address();
    }
}
