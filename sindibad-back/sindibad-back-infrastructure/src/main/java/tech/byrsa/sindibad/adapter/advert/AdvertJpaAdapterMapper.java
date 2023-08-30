package tech.byrsa.sindibad.adapter.advert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tech.byrsa.sindibad.database.entity.AdvertCarDb;
import tech.byrsa.sindibad.database.entity.AdvertDb;
import tech.byrsa.sindibad.database.entity.AdvertImmoDb;
import tech.byrsa.sindibad.database.entity.UserAccountDb;
import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.model.AdvertCar;
import tech.byrsa.sindibad.individual.advert.model.AdvertCreate;
import tech.byrsa.sindibad.individual.advert.model.AdvertImmo;

@Mapper
public interface AdvertJpaAdapterMapper {
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "lastModifiedBy", ignore = true)
	@Mapping(target = "lastModifiedDate", ignore = true)
	@Mapping(target = "userAccount", ignore = true)
	@Mapping(target = "advert_type", ignore = true)
	AdvertCarDb map(AdvertCar advert);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "lastModifiedBy", ignore = true)
	@Mapping(target = "lastModifiedDate", ignore = true)
	@Mapping(target = "userAccount", ignore = true)
	@Mapping(target = "advert_type", ignore = true)
	AdvertImmoDb map(AdvertImmo advert);

	default Advert map(AdvertDb advert){
		if(advert.getAdvert_type() == 1){
			AdvertCar ac = new AdvertCar();
			ac.setId(advert.getId());
			ac.setTitle(advert.getTitle());
			ac.setDescription(advert.getDescription());
			Advert.User u = new Advert.User();
			u.setId(advert.getUserAccount().getId());
			ac.setCreator(u);
			return ac;
		}else{
			AdvertImmo ad = new AdvertImmo();
			ad.setId(advert.getId());
			ad.setTitle(advert.getTitle());
			ad.setDescription(advert.getDescription());
			Advert.User u = new Advert.User();
			u.setId(advert.getUserAccount().getId());
			ad.setCreator(u);
			return ad;
		}
	}
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "lastModifiedBy", ignore = true)
	@Mapping(target = "lastModifiedDate", ignore = true)
	@Mapping(target = "userAccount", source = "userAccountDb")
	//@Mapping(target = "advert_type", ignore = true)
	AdvertImmoDb map1(AdvertCreate advertCreate, UserAccountDb userAccountDb);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "lastModifiedBy", ignore = true)
	@Mapping(target = "lastModifiedDate", ignore = true)
	@Mapping(target = "userAccount", source = "userAccountDb")
		//@Mapping(target = "advert_type", ignore = true)
	AdvertCarDb map2(AdvertCreate advertCreate, UserAccountDb userAccountDb);
}
