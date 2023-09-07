package tech.byrsa.sindibad.adapter.enterprise;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.byrsa.sindibad.database.entity.EnterpriseDb;
import tech.byrsa.sindibad.database.entity.UserAccountDb;
import tech.byrsa.sindibad.enterprise.model.Enterprise;

@Mapper
public interface EnterpriseJpaAdapterMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "responsableUser", source="userAccountDb")
    @Mapping(target= "adverts", ignore = true)
    @Mapping(target="members", ignore = true)
    EnterpriseDb map(Enterprise e, UserAccountDb userAccountDb);

    @Mapping(target= "adverts", ignore = true)
    @Mapping(target="members", ignore = true)
    @Mapping(target="responsableUser.id", source = "responsableUser.id")
    Enterprise map(EnterpriseDb e);
}
