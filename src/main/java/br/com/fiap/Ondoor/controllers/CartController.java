package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @GetMapping(value = "/cart")
    public Cart show() { return new Cart();}

        @Autowired
        private CartService cartService;

        @GetMapping
        public List<Cart> findAll() {
            return cartService.findAll();
        }

        @GetMapping("/{id}")
        public Cart findById(@PathVariable Long id) {
            return cartService.findById(id);
        }

        @PostMapping
        public Cart save(@RequestBody Cart cart) {
            return cartService.save(cart);
        }

        @PutMapping("/{id}")
        public Cart update(@PathVariable Long id, @RequestBody Cart cart) {
            Cart existingCart = cartService.findById(id);
            existingCart.setItems(cart.getItems());
            return cartService.save(existingCart);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            cartService.delete(id);
        }

    }


