package tech.byrsa.sindibad.database.repository;

import org.springframework.stereotype.Repository;
import tech.byrsa.sindibad.database.entity.UserAccountDb;

@Repository
public interface UserAccountRepository extends SpecificationRepository<UserAccountDb, Long> {

    UserAccountDb findByEmail(String email);
}
