package tech.byrsa.sindibad.useraccount.model;

import lombok.Data;

@Data
public class UserAccountCreate {
	private String email;
	private String password;
	private String firstname;
	private String lastname;
}
