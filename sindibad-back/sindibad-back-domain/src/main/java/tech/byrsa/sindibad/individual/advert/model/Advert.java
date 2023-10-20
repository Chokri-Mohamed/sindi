package tech.byrsa.sindibad.individual.advert.model;

import java.time.Instant;

import lombok.Data;

@Data
public class Advert {

	private Long id;
	private String title;
	private String description;
	private String governorat;
	private User creator;
	private String createdBy;
	private String lastModifiedBy;
	private Instant createdDate;
	private Instant lastModifiedDate;

	@Data
	public static class User {
		private Long id;
	}
}
