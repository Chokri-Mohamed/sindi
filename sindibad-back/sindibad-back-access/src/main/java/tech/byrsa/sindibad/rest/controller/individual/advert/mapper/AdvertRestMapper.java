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
	default PaginatedAdvertResponse mapToPaginatedAdvert(Advert advert){
		PaginatedAdvertResponse p = new PaginatedAdvertResponse();
		p.setId(advert.getId());
		p.setDescription(advert.getDescription());
		p.setTitle(advert.getTitle());
		p.setGovernorat(advert.getGovernorat());
		p.setUserId(advert.getCreator().getId());
		if(advert.getClass().getTypeName().equals("tech.byrsa.sindibad.individual.advert.model.AdvertCar")){
			p.setAdvert_type(1);
		}else{
			p.setAdvert_type(2);
		}
		return p;
	}

	@Mapping(target = "userId", source = "creator.id")
	default DetailedAdvertResponse mapToDetailedAdvert(Advert advert){
		DetailedAdvertResponse p = new DetailedAdvertResponse();
		p.setId(advert.getId());
		p.setDescription(advert.getDescription());
		p.setTitle(advert.getTitle());
		p.setUserId(advert.getCreator().getId());
		if(advert.getClass().getTypeName().equals("AdvertCar")){
			p.setAdvert_type(1);
		}else{
			p.setAdvert_type(2);
		}
		return p;
	}

	AdvertCreate map(CreateAdvertRequest createAdvertRequest, Long userId);

	@Mapping(target = "title", source = "updateAdvertRequest.title")

	@Mapping(target = "description", source = "updateAdvertRequest.description")

	AdvertUpdate map(Long id, UpdateAdvertRequest updateAdvertRequest);
	@Mapping(target = "title", source = "advert.title")
	@Mapping(target = "description", source = "advert.description")

	AdvertUpdate map(Advert advert);

	default <T> boolean map(JsonNullable<T> value) {
		if(value == null) {
			return true;
		}
		return value.isPresent();
	}

}
