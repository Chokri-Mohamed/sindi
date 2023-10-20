package tech.byrsa.sindibad.rest.controller.individual.advert.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginatedAdvertResponse {
	private Long id;
    private String title;
    private String description;
    private String governorat;
    private int advert_type;
    private Long userId;
}
