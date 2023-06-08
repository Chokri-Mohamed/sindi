package tech.byrsa.sindibad.individual.advert;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.model.AdvertCreate;
import tech.byrsa.sindibad.individual.advert.model.AdvertUpdate;
import tech.byrsa.sindibad.individual.advert.port.in.CreateAdvertUseCase;
import tech.byrsa.sindibad.individual.advert.port.in.GetDetailedAdvertQuery;
import tech.byrsa.sindibad.individual.advert.port.in.GetPaginatedAdvertsQuery;
import tech.byrsa.sindibad.individual.advert.port.in.UpdateAdvertUseCase;
import tech.byrsa.sindibad.individual.advert.port.out.GetAdvert;
import tech.byrsa.sindibad.individual.advert.port.out.GetPageAdverts;
import tech.byrsa.sindibad.individual.advert.port.out.SaveAdvert;
import tech.byrsa.sindibad.individual.advert.port.out.UpdateAdvert;

@Service
@RequiredArgsConstructor
public class CRUDAdvertService implements GetDetailedAdvertQuery, GetPaginatedAdvertsQuery, CreateAdvertUseCase, UpdateAdvertUseCase{

	private final GetAdvert getAdvert;
	private final GetPageAdverts getPageAdverts;
	private final UpdateAdvert updateAdvert;
	private final SaveAdvert saveAdvert;
	
	@Override
	public Page<Advert> getPaginatedAdverts(Pageable pageable) {
		Page<Advert> adverts = getPageAdverts.getPageAdverts(pageable);
		return adverts;
	}

	@Override
	public Advert getDetailedAdvert(Long id) {
		Advert advert = getAdvert.getAdvert(id);
		return advert;
	}

	@Override
	public Long createAdvert(AdvertCreate advertCreate) {
		Advert advert = saveAdvert.createAdvert(advertCreate);
		return advert.getId();
	}

	@Override
	public void updateAdvert(AdvertUpdate advertUpdate) {
		updateAdvert.updateAdvert(advertUpdate);
	}

}