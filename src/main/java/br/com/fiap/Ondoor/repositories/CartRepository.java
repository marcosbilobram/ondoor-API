package br.com.fiap.Ondoor.repositories;

import br.com.fiap.Ondoor.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
