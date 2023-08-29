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
import tech.byrsa.sindibad.useraccount.port.out.DeleteAdvert;

@XSlf4j
@Component
@RequiredArgsConstructor
public class AdvertJpaAdapter implements SaveAdvert, GetAdvert, GetPageAdverts, UpdateAdvert, DeleteAdvert {

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
		AdvertDb advertDb = optAdvert.orElse(null);
		if(advertDb == null) return null;
		return advertJpaMapper.map(advertDb);
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
		public Advert updateAdvert(AdvertUpdate advertUpdate) {
		Specification<AdvertDb> specs = Specification.where(AdvertSpecification.byId(advertUpdate.getId()));
		AdvertDb adb = advertRepository.findOne(specs).orElse(null);
		if(adb == null) return null;
		adb.setTitle(advertUpdate.getTitle());
		adb.setDescription(advertUpdate.getDescription());
		adb = advertRepository.save(adb);
		return advertJpaMapper.map(adb);
	}

	@Override
	public void delete(Long id) {
		advertRepository.deleteById(id);
	}
}
