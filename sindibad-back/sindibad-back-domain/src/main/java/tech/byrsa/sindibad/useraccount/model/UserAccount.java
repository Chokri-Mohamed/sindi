package tech.byrsa.sindibad.useraccount.model;

import lombok.Data;
import tech.byrsa.sindibad.enumerated.Gender;

@Data
public class UserAccount {
	private Long id;
	private String email;
	private String firstname;
	private String lastname;
	private Gender gender;

}
