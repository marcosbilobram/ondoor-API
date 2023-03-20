package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    Logger log = LoggerFactory.getLogger(ProductController.class);

    List<Product> products = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = products.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (obj == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody Product product) {
        products.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Product product) {
        log.info("alterando endereço com id " + id);
        Product obj = products.stream().filter(d -> d.getId().equals(id)).findFirst().get();

        if (obj == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        products.remove(obj);
        product.setId(id);
        products.add(product);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        products.get(Integer.parseInt(String.valueOf(id)));
        return ResponseEntity.ok().build();
    }

}

