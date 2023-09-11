package tech.byrsa.sindibad.database.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tech.byrsa.sindibad.database.entity.AdvertDb;

@Repository
public interface AdvertRepository extends SpecificationRepository<AdvertDb, Long>, PagingAndSortingRepository<AdvertDb, Long> {

}
