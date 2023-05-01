package br.com.fiap.Ondoor.repositories;

import br.com.fiap.Ondoor.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
