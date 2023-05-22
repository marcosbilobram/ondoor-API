package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Category;
import br.com.fiap.Ondoor.entities.Restaurant;
import br.com.fiap.Ondoor.repositories.CategoryRepository;
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

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    CategoryRepository repo;

    @GetMapping
    public Page<Category> findAll(@PageableDefault(size = 5) Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {

        Category ads = repo.findById(id).get();

        if (ads == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok().body(ads);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> insert(@RequestBody @Valid Category Category) {
        repo.save(Category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid Category Category) {
        log.info("alterando endereço com id " + id);
        var ads = repo.findById(id);

        if (ads.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repo.delete(ads.get());
        Category.setId(id);
        repo.save(Category);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @DeleteMapping("/{id}/del")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
