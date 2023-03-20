package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    Logger log = LoggerFactory.getLogger(RatingController.class);

    List<Rating> ratings = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Rating>> findAll() {
        return ResponseEntity.ok().body(ratings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> findById(@PathVariable Long id) {
        Rating obj = ratings.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (obj == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody Rating rating) {
        ratings.add(rating);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Rating rating) {
        log.info("alterando endereço com id " + id);
        Rating obj = ratings.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (obj == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        ratings.remove(obj);
        rating.setId(id);
        ratings.add(rating);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ratings.get(Integer.parseInt(String.valueOf(id)));
        return ResponseEntity.ok().build();
    }

}

