package br.com.fiap.Ondoor.repositories;

import br.com.fiap.Ondoor.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
