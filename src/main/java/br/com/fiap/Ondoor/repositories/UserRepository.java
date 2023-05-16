package br.com.fiap.Ondoor.repositories;

import br.com.fiap.Ondoor.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);

}
