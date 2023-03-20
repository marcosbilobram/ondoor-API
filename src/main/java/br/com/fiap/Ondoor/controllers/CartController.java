package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    Logger log = LoggerFactory.getLogger(CartController.class);

    List<Cart> carts = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Cart>> findAll() {
        return ResponseEntity.ok().body(carts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> findById(@PathVariable Long id) {
        Cart cart = carts.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (cart == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(cart);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody Cart cart) {
        carts.add(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Cart cart) {
        log.info("alterando endereço com id " + id);
        var crt = carts.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (crt.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        carts.remove(crt);
        cart.setId(id);
        carts.add(cart);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public void delete(@PathVariable Long id) {
        carts.get(Integer.parseInt(String.valueOf(id)));
        ResponseEntity.ok().build();
    }

    }


