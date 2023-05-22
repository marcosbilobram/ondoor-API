package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Order;
import br.com.fiap.Ondoor.entities.Order;
import br.com.fiap.Ondoor.entities.Restaurant;
import br.com.fiap.Ondoor.repositories.OrderRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    OrderRepository repo;

    @GetMapping
    public Page<Order> findAll(@PageableDefault(size = 5) Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {

        Order ads = repo.findById(id).get();

        if (ads == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(ads);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody @Valid Order Order) {
        repo.save(Order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid Order Order) {
        log.info("alterando endereço com id " + id);
        var ads = repo.findById(id);

        if (ads.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repo.delete(ads.get());
        Order.setId(id);
        repo.save(Order);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
