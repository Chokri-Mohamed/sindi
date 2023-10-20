package tech.byrsa.sindibad.database.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import tech.byrsa.sindibad.database.entity.EnterpriseDb;

@Repository
public interface EnterpriseRepository
		extends SpecificationRepository<EnterpriseDb, Long>, PagingAndSortingRepository<EnterpriseDb, Long> {
}
