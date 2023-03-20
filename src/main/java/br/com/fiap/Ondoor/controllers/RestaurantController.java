package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    Logger log = LoggerFactory.getLogger(RestaurantController.class);

    List<Restaurant> restaurants = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Restaurant>> findAll() {
        return ResponseEntity.ok().body(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable Long id) {
        Restaurant obj = restaurants.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (obj == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody Restaurant restaurant) {
        restaurants.add(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        log.info("alterando endereço com id " + id);
        Restaurant obj = restaurants.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (obj == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        restaurants.remove(obj);
        restaurant.setId(id);
        restaurants.add(restaurant);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        restaurants.get(Integer.parseInt(String.valueOf(id)));
        return ResponseEntity.ok().build();
    }

}

