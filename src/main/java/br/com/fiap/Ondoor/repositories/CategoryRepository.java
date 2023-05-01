package br.com.fiap.Ondoor.repositories;

import br.com.fiap.Ondoor.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
