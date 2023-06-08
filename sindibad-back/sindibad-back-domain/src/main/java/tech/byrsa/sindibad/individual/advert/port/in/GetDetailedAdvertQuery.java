package tech.byrsa.sindibad.individual.advert.port.in;

import tech.byrsa.sindibad.individual.advert.model.Advert;

public interface GetDetailedAdvertQuery {

	Advert getDetailedAdvert(Long id);

}
