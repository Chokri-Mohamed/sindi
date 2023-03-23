package tech.byrsa.sindibad.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SpecificationRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
