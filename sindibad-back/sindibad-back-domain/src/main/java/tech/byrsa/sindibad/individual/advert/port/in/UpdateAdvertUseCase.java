package tech.byrsa.sindibad.individual.advert.port.in;

import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.model.AdvertUpdate;

public interface UpdateAdvertUseCase {

	Advert updateAdvert(AdvertUpdate advertUpdate);

}
