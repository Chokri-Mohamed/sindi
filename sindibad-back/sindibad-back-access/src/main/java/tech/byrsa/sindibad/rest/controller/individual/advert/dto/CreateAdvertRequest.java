package tech.byrsa.sindibad.rest.controller.individual.advert.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAdvertRequest {
	private String title;
	private String description;
	private int advert_type;
}
