package tech.byrsa.sindibad.individual.advert.port.in;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tech.byrsa.sindibad.individual.advert.model.Advert;

public interface GetPaginatedAdvertsQuery {

	Page<Advert> getPaginatedAdverts(Pageable pageable);

}
