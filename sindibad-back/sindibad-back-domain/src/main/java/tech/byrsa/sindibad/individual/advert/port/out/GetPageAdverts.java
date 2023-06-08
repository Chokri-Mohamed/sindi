package tech.byrsa.sindibad.individual.advert.port.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tech.byrsa.sindibad.individual.advert.model.Advert;

public interface GetPageAdverts {

	Page<Advert> getPageAdverts(Pageable pageable);

}
