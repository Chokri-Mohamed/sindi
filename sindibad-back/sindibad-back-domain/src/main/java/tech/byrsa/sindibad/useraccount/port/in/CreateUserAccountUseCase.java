package tech.byrsa.sindibad.useraccount.port.in;

import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;

public interface CreateUserAccountUseCase {
	Long createUserAccount(UserAccountCreate userAccountCreate);


}
