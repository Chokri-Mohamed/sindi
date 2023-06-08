package tech.byrsa.sindibad.adapter.advert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tech.byrsa.sindibad.database.entity.AdvertDb;
import tech.byrsa.sindibad.database.entity.UserAccountDb;
import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.model.AdvertCreate;

@Mapper
public interface AdvertJpaAdapterMapper {
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "lastModifiedBy", ignore = true)
	@Mapping(target = "lastModifiedDate", ignore = true)
	@Mapping(target = "userAccount", ignore = true)
	AdvertDb map(Advert advert);

	@Mapping(target = "creator.id", source = "userAccount.id")
	Advert map(AdvertDb advert);

	@Mapping(target = "userAccount", source = "userAccountDb")
	AdvertDb map(AdvertCreate advertCreate, UserAccountDb userAccountDb);

}
