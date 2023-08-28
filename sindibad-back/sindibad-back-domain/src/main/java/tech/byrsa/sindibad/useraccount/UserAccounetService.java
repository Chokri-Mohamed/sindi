package tech.byrsa.sindibad.useraccount;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;
import tech.byrsa.sindibad.useraccount.port.in.CreateUserAccountUseCase;
import tech.byrsa.sindibad.useraccount.port.out.SaveUserAccount;

@Service
@RequiredArgsConstructor
public class UserAccounetService implements CreateUserAccountUseCase {
	private final PasswordEncoder passwordEncoder;
	private final SaveUserAccount saveUserAccount;

	@Override
	public Long createUserAccount(UserAccountCreate userAccountCreate) {
		final String encodedPassword = passwordEncoder.encode(userAccountCreate.getPassword());
        userAccountCreate.setPassword(encodedPassword);
		UserAccount userAccount = saveUserAccount.createUserAccount(userAccountCreate);
		return userAccount.getId();
	}
}
