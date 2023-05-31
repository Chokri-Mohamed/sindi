package tech.byrsa.sindibad.rest.controller.annonce.dto.response;

import lombok.Data;

@Data
public class GetAnnonceResponse {
	private Long id;
    private String title;
    private String description;

}
