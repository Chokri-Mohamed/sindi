package tech.byrsa.sindibad.individual.advert.model;

import lombok.Data;

@Data
public class AdvertUpdate {
	private Long id;
	private String title;
	private boolean submittedTitle;
	private String description;
	private boolean submittedDescription;
}
