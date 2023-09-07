package tech.byrsa.sindibad.adapter.useraccount;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tech.byrsa.sindibad.database.entity.UserAccountDb;
import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;

@Mapper
public interface UserAccountJpaAdapterMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "adverts", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "lastModifiedBy", ignore = true)
	@Mapping(target = "lastModifiedDate", ignore = true)
	UserAccountDb map(UserAccountCreate userAccountCreate);

	UserAccount map(UserAccountDb userAccountDb);

	@Mapping(target = "version", ignore = true)
	@Mapping(target = "adverts", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "lastModifiedBy", ignore = true)
	@Mapping(target = "lastModifiedDate", ignore = true)
	@Mapping(target = "password", ignore = true)
	UserAccountDb map(UserAccount userAccount);
}
