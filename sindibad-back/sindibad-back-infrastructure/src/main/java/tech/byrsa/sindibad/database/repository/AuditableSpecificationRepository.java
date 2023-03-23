package tech.byrsa.sindibad.database.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.history.RevisionRepository;

@NoRepositoryBean
public interface AuditableSpecificationRepository<T, ID, N extends Number & Comparable<N>> extends RevisionRepository<T, ID, N>, SpecificationRepository<T, ID> {
}
