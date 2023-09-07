package tech.byrsa.sindibad.database.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tech.byrsa.sindibad.database.entity.AdvertDb;

public interface AdvertRepository extends SpecificationRepository<AdvertDb, Long>, PagingAndSortingRepository<AdvertDb, Long> {

}
