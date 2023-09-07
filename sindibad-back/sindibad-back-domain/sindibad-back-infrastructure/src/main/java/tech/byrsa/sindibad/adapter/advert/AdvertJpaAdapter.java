package tech.byrsa.sindibad.adapter.advert;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import tech.byrsa.sindibad.database.entity.AdvertCarDb;
import tech.byrsa.sindibad.database.entity.AdvertDb;
import tech.byrsa.sindibad.database.entity.AdvertImmoDb;
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
		//System.err.println(adverts.getContent().stream().filter(e -> e.getClass().getTypeName().equals("tech.byrsa.sindibad.individual.advert.model.AdvertCar")).toList().get(0).getClass().getTypeName());
		//System.err.println(adverts.getContent().stream().filter(element -> element.getAdvert_type() == 1).toList().get(0).getAdvert_type());
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

		System.err.println(advertCreate.toString());
		AdvertCarDb acd;
		AdvertImmoDb aid;
		AdvertDb savedAdvertDb;
		if(advertCreate.getAdvert_type() == 1) {
			acd = advertJpaMapper.map2(advertCreate, userAccountDb);
			savedAdvertDb = advertRepository.save(acd);
		}else{
			aid = advertJpaMapper.map1(advertCreate, userAccountDb);
			savedAdvertDb = advertRepository.save(aid);
		}
		System.err.println(savedAdvertDb.toString());
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
