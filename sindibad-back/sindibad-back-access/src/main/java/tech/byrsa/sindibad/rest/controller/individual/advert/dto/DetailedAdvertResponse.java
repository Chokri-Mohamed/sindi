package tech.byrsa.sindibad.rest.controller.individual.advert.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailedAdvertResponse {
	private Long id;
	private String title;
	private String description;
	private String governorat;
	private Long userId;
	private int advert_type;
}
