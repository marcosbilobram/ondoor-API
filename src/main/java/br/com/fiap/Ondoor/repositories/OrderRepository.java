package br.com.fiap.Ondoor.repositories;

import br.com.fiap.Ondoor.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
