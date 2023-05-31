package tech.byrsa.sindibad.rest.controller.annonce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import tech.byrsa.sindibad.annonce.model.Annonce;
import tech.byrsa.sindibad.annonce.model.WriteNewAnnonce;
import tech.byrsa.sindibad.rest.controller.annonce.dto.request.WriteNewAnnonceRequest;
import tech.byrsa.sindibad.rest.controller.annonce.dto.response.GetAnnonceResponse;

@Mapper
public interface AnnonceRestMapper {

	WriteNewAnnonce map(WriteNewAnnonceRequest writeNewAnnonce);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "title", ignore = true)
	@Mapping(target = "description", ignore = true)
	GetAnnonceResponse map(Page<Annonce> annonce);

}
