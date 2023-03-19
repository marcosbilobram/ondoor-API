package br.com.fiap.Ondoor.controllers;

import br.com.fiap.Ondoor.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @GetMapping(value = "/rating")
    public Rating show() { return new Rating();}
        @Autowired
        private RatingService ratingService;

        @GetMapping
        public List<Rating> findAll() {
            return ratingService.findAll();
        }

        @GetMapping("/{id}")
        public Rating findById(@PathVariable Long id) {
            return ratingService.findById(id);
        }

        @PostMapping
        public Rating save(@RequestBody Rating rating) {
            return ratingService.save(rating);
        }

        @PutMapping("/{id}")
        public Rating update(@PathVariable Long id, @RequestBody Rating rating) {
            Rating existingRating = ratingService.findById(id);
            existingRating.setValue(rating.getValue());
            existingRating.setComment(rating.getComment());
            return ratingService.save(existingRating);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            ratingService.delete(id);
        }

    }

