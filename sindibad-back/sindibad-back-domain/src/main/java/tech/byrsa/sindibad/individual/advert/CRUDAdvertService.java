package tech.byrsa.sindibad.individual.advert;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.model.AdvertCreate;
import tech.byrsa.sindibad.individual.advert.model.AdvertUpdate;
import tech.byrsa.sindibad.individual.advert.port.in.*;
import tech.byrsa.sindibad.individual.advert.port.out.*;
import tech.byrsa.sindibad.useraccount.port.out.DeleteAdvert;
import tech.byrsa.sindibad.useraccount.port.out.GetUserAccount;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CRUDAdvertService implements GetDetailedAdvertQuery, SearchUsecase, GetPaginatedAdvertsQuery, CreateAdvertUseCase, UpdateAdvertUseCase, DeleteAdvertUseCase {

	private final GetAdvert getAdvert;
	private final GetPageAdverts getPageAdverts;
	private final UpdateAdvert updateAdvert;
	private final SaveAdvert saveAdvert;
	private final DeleteAdvert deleteAdvert;
	private final GetUserAccount getUserAccount;
	private final SearchAdvert searchAdvert;

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
		if(getUserAccount.getUserAccountById(advertCreate.getUserId()) == null){
			return null;
		}
		Advert advert = saveAdvert.createAdvert(advertCreate);
		return advert.getId();
	}

	@Override
	public Advert updateAdvert(AdvertUpdate advertUpdate) {
		Advert at = updateAdvert.updateAdvert(advertUpdate);
		System.err.println(at);
		return at;
	}

	@Override
	public boolean delete(Long id) {
		Advert advert = getAdvert.getAdvert(id);
		if(advert == null) return false;
		deleteAdvert.delete(id);
		return true;
	}

	@Override
	public List<Advert> search(String eq) {
		List<Advert> e = searchAdvert.search(eq);
		return e;
	}
}
