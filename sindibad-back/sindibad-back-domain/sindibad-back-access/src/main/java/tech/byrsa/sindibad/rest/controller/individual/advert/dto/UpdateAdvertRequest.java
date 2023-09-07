package tech.byrsa.sindibad.rest.controller.individual.advert.dto;

import org.openapitools.jackson.nullable.JsonNullable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAdvertRequest {
	private String title;
	private String description;
}
