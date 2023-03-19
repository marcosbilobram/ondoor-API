package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping(value = "/product")
    public Product show() { return new Product();}

        @Autowired
        private ProductService productService;

        @GetMapping
        public List<Product> findAll() {
            return productService.findAll();
        }

        @GetMapping("/{id}")
        public Product findById(@PathVariable Long id) {
            return productService.findById(id);
        }

        @PostMapping
        public Product save(@RequestBody Product product) {
            return productService.save(product);
        }

        @PutMapping("/{id}")
        public Product update(@PathVariable Long id, @RequestBody Product product) {
            Product existingProduct = productService.findById(id);
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            return productService.save(existingProduct);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            productService.delete(id);
        }

    }

