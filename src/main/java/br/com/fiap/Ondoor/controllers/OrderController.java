package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping(value = "/order")
    public Order show() { return new Order();}

        @Autowired
        private OrderService orderService;

        @GetMapping
        public List<Order> findAll() {
            return orderService.findAll();
        }

        @GetMapping("/{id}")
        public Order findById(@PathVariable Long id) {
            return orderService.findById(id);
        }

        @PostMapping
        public Order save(@RequestBody Order order) {
            return orderService.save(order);
        }

        @PutMapping("/{id}")
        public Order update(@PathVariable Long id, @RequestBody Order order) {
            Order existingOrder = orderService.findById(id);
            existingOrder.setClient(order.getClient());
            existingOrder.setProducts(order.getProducts());
            return orderService.save(existingOrder);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            orderService.delete(id);
        }

    }
}
