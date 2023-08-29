package tech.byrsa.sindibad.individual.advert.port.out;

import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.model.AdvertUpdate;

public interface UpdateAdvert {

	Advert updateAdvert(AdvertUpdate advertUpdate);

}
