package tech.byrsa.sindibad.adapter.annonce;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tech.byrsa.sindibad.annonce.model.Annonce;
import tech.byrsa.sindibad.annonce.model.WriteNewAnnonce;
import tech.byrsa.sindibad.database.entity.AnnonceDb;

@Mapper
public interface AnnonceDbMapper {
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "createdBy", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "lastModifiedBy", ignore = true)
	@Mapping(target = "lastModifiedDate", ignore = true)
	AnnonceDb map(WriteNewAnnonce newAnnonce);

	Annonce mapa(AnnonceDb getAnnonceResponse);

}
