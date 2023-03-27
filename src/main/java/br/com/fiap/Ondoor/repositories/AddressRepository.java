package br.com.fiap.Ondoor.repositories;

import br.com.fiap.Ondoor.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
