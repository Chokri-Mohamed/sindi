package tech.byrsa.sindibad.adapter.advert;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import tech.byrsa.sindibad.database.entity.AdvertDb;
import tech.byrsa.sindibad.database.entity.UserAccountDb;
import tech.byrsa.sindibad.database.repository.AdvertRepository;
import tech.byrsa.sindibad.database.repository.UserAccountRepository;
import tech.byrsa.sindibad.database.specification.AdvertSpecification;
import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.model.AdvertCreate;
import tech.byrsa.sindibad.individual.advert.model.AdvertUpdate;
import tech.byrsa.sindibad.individual.advert.port.out.GetAdvert;
import tech.byrsa.sindibad.individual.advert.port.out.GetPageAdverts;
import tech.byrsa.sindibad.individual.advert.port.out.SaveAdvert;
import tech.byrsa.sindibad.individual.advert.port.out.UpdateAdvert;

@XSlf4j
@Component
@RequiredArgsConstructor
public class AdvertJpaAdapter implements SaveAdvert, GetAdvert, GetPageAdverts, UpdateAdvert {

	private final UserAccountRepository userAccountRepository;
	private final AdvertRepository advertRepository;
	private final AdvertJpaAdapterMapper advertJpaMapper;

	@Override
	public Page<Advert> getPageAdverts(Pageable pageable) {
		Page<AdvertDb> advertsDb = advertRepository.findAll(pageable);
		Page<Advert> adverts = advertsDb.map(advertJpaMapper::map);
		return adverts;
	}

	@Override
	public Advert getAdvert(Long id) {
		Specification<AdvertDb> specs = Specification.where(AdvertSpecification.byId(id));
		Optional<AdvertDb> optAdvert = advertRepository.findOne(specs);
		AdvertDb advertDb = optAdvert.orElseThrow();
		Advert advert = advertJpaMapper.map(advertDb);
		return advert;
	}

	@Override
	@Transactional
	public Advert createAdvert(AdvertCreate advertCreate) {
		UserAccountDb userAccountDb = userAccountRepository.getReferenceById(advertCreate.getUserId());

		AdvertDb advertDb = advertJpaMapper.map(advertCreate, userAccountDb);

		AdvertDb savedAdvertDb = advertRepository.save(advertDb);
		Advert advert = advertJpaMapper.map(savedAdvertDb);
		return advert;
	}

	@Transactional
	public void updateAdvert(AdvertUpdate advertUpdate) {
		Specification<AdvertDb> specs = Specification.where(AdvertSpecification.byId(advertUpdate.getId()));
		Optional<AdvertDb> optAdvertDb = advertRepository.findOne(specs);

		AdvertDb advertDb = optAdvertDb.orElseThrow();
		if (advertUpdate.isSubmittedTitle()) {
			advertDb.setTitle(advertUpdate.getTitle());
		}
		if (advertUpdate.isSubmittedDescription()) {
			advertDb.setDescription(advertUpdate.getDescription());
		}
	}

}
