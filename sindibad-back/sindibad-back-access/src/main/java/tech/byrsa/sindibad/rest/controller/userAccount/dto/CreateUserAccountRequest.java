package tech.byrsa.sindibad.rest.controller.userAccount.dto;

import lombok.Getter;
import lombok.Setter;
import tech.byrsa.sindibad.enumerated.Gender;

@Getter
@Setter
public class CreateUserAccountRequest {
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private Gender gender;
	


}
