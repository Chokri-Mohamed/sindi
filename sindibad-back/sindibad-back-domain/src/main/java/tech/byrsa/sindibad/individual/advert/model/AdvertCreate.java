package tech.byrsa.sindibad.individual.advert.model;

import lombok.Data;

@Data
public class AdvertCreate {
	private String title;
	private String description;
	private Long userId;
	private int advert_type;
}
