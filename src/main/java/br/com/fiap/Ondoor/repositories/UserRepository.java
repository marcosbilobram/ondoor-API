package br.com.fiap.Ondoor.repositories;

import br.com.fiap.Ondoor.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
