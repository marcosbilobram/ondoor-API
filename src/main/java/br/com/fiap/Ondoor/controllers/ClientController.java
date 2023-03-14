package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping(value = "/client")
    public Client show() { return new Client();}
}
