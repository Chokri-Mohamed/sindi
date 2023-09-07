package tech.byrsa.sindibad.database.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.byrsa.sindibad.database.entity.AdvertDb;
import tech.byrsa.sindibad.database.entity.EnterpriseDb;

@Repository
public interface EnterpriseRepository extends SpecificationRepository<EnterpriseDb, Long> , PagingAndSortingRepository<EnterpriseDb, Long> {
}
