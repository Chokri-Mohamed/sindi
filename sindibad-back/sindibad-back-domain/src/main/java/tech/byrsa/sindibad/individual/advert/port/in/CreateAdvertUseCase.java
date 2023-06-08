package tech.byrsa.sindibad.individual.advert.port.in;

import tech.byrsa.sindibad.individual.advert.model.AdvertCreate;

public interface CreateAdvertUseCase {

	Long createAdvert(AdvertCreate advertCreate);

}
