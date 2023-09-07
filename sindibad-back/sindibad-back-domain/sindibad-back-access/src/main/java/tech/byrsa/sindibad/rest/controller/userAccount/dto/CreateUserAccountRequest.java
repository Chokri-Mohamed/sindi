package tech.byrsa.sindibad.rest.controller.userAccount.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserAccountRequest {
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	


}
