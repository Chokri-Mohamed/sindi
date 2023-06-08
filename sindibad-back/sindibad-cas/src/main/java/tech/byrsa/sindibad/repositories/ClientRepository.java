package tech.byrsa.sindibad.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.byrsa.sindibad.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
	Optional<Client> findByClientId(String clientId);

	

}