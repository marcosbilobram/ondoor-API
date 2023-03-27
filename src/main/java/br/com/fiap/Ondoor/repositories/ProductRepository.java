package br.com.fiap.Ondoor.repositories;

import br.com.fiap.Ondoor.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
