package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    Logger log = LoggerFactory.getLogger(OrderController.class);

    List<Order> orders = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order order = orders.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (order == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(order);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody Order order) {
        orders.add(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Order order) {
        log.info("alterando endereço com id " + id);
        Order ord = orders.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (ord == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        orders.remove(ord);
        order.setId(id);
        orders.add(order);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orders.get(Integer.parseInt(String.valueOf(id)));
        return ResponseEntity.ok().build();
    }
}
