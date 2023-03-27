package br.com.fiap.Ondoor.repositories;

import br.com.fiap.Ondoor.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
