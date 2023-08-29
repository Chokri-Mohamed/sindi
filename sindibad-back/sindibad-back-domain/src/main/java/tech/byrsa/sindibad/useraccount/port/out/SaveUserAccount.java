package tech.byrsa.sindibad.useraccount.port.out;

import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;

public interface SaveUserAccount {
	UserAccount createUserAccount(UserAccountCreate userAccountCreate);
	UserAccount modifyUserAccount(Long id, UserAccount userAccount);

}
