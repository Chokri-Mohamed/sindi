package tech.byrsa.sindibad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.byrsa.sindibad.entites.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
	UserAccount findByEmail(String email);

}
