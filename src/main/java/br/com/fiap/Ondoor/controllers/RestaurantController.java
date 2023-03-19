package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @GetMapping(value = "/restaurant")
    public Restaurant show() { return new Restaurant();}

        @Autowired
        private RestaurantService restaurantService;

        @GetMapping
        public List<Restaurant> findAll() {
            return restaurantService.findAll();
        }

        @GetMapping("/{id}")
        public Restaurant findById(@PathVariable Long id) {
            return restaurantService.findById(id);
        }

        @PostMapping
        public Restaurant save(@RequestBody Restaurant restaurant) {
            return restaurantService.save(restaurant);
        }

        @PutMapping("/{id}")
        public Restaurant update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
            Restaurant existingRestaurant = restaurantService.findById(id);
            existingRestaurant.setName(restaurant.getName());
            existingRestaurant.setAddress(restaurant.getAddress());
            return restaurantService.save(existingRestaurant);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            restaurantService.delete(id);
        }

    }

