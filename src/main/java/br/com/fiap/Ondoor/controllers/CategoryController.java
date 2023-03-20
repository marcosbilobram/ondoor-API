package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    Logger log = LoggerFactory.getLogger(CategoryController.class);

    List<Category> categories = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category address = categories.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (address == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(address);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody Category category) {
        categories.add(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Category category) {
        log.info("alterando endereço com id " + id);
        Category ctg = categories.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (ctg == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        categories.remove(ctg);
        category.setId(id);
        categories.add(category);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categories.get(Integer.parseInt(String.valueOf(id)));
        return ResponseEntity.ok().build();
    }

}
