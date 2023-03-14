package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "/user")
    public User show() { return new User();}
}
