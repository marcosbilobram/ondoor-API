package br.com.fiap.Ondoor.repositories;

import br.com.fiap.Ondoor.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
