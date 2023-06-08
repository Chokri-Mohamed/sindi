package tech.byrsa.sindibad.rest.controller.individual.advert.dto;

import org.openapitools.jackson.nullable.JsonNullable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAdvertRequest {
	private JsonNullable<String> title = JsonNullable.undefined();
	private JsonNullable<String> description = JsonNullable.undefined();
}
