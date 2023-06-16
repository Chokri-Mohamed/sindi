package tech.byrsa.sindibad.useraccount;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;
import tech.byrsa.sindibad.useraccount.port.in.CreateUserAccountUseCase;
import tech.byrsa.sindibad.useraccount.port.out.SaveUserAccount;

@Service
@RequiredArgsConstructor
public class UserAccounetService implements CreateUserAccountUseCase {
	private final SaveUserAccount saveUserAccount;

	@Override
	public Long createUserAccount(UserAccountCreate userAccountCreate) {
		UserAccount userAccount = saveUserAccount.createUserAccount(userAccountCreate);
		return userAccount.getId();
	}
}
