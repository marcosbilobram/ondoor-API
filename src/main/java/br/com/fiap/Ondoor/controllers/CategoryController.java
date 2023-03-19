package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping(value = "/category")
    public Category show() { return new Category();}

        @Autowired
        private CategoryService categoryService;

        @GetMapping
        public List<Category> findAll() {
            return categoryService.findAll();
        }

        @GetMapping("/{id}")
        public Category findById(@PathVariable Long id) {
            return categoryService.findById(id);
        }

        @PostMapping
        public Category save(@RequestBody Category category) {
            return categoryService.save(category);
        }

        @PutMapping("/{id}")
        public Category update(@PathVariable Long id, @RequestBody Category category) {
            Category existingCategory = categoryService.findById(id);
            existingCategory.setName(category.getName());
            return categoryService.save(existingCategory);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            categoryService.delete(id);
        }

    }
}
