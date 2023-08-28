package tech.byrsa.sindibad.rest.controller.individual.advert.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.jackson.nullable.JsonNullable;

import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.model.AdvertCreate;
import tech.byrsa.sindibad.individual.advert.model.AdvertUpdate;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.CreateAdvertRequest;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.DetailedAdvertResponse;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.PaginatedAdvertResponse;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.UpdateAdvertRequest;

@Mapper
public interface AdvertRestMapper {

	@Mapping(target = "id")
	@Mapping(target = "title")
	@Mapping(target = "description")
	PaginatedAdvertResponse mapToPaginatedAdvert(Advert advert);

	@Mapping(target = "userId", source = "creator.id")
	DetailedAdvertResponse mapToDetailedAdvert(Advert advert);

	AdvertCreate map(CreateAdvertRequest createAdvertRequest, Long userId);

	@Mapping(target = "title", source = "updateAdvertRequest.title")
	@Mapping(target = "description", source = "updateAdvertRequest.description")
	@Mapping(target = "submittedTitle", ignore = true)
	@Mapping(target = "submittedDescription", ignore = true)
	AdvertUpdate map(Long id, UpdateAdvertRequest updateAdvertRequest);
	
	default <T> boolean map(JsonNullable<T> value) {
		if(value == null) {
			return true;
		}
		return value.isPresent();
	}

}
