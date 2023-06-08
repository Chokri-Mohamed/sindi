package tech.byrsa.sindibad.individual.advert.port.out;

import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.model.AdvertCreate;

public interface SaveAdvert {

	Advert createAdvert(AdvertCreate advertCreate);

}
