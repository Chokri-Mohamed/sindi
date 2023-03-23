package tech.byrsa.sindibad.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.history.RevisionRepository;

@NoRepositoryBean
public interface AuditableRepository<T, ID, N extends Number & Comparable<N>> extends RevisionRepository<T, ID, N>, JpaRepository<T, ID> {
}
