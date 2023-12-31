package tech.byrsa.sindibad.useraccount;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;
import tech.byrsa.sindibad.useraccount.port.in.CreateUserAccountUseCase;
import tech.byrsa.sindibad.useraccount.port.in.GetUserAccountUseCase;
import tech.byrsa.sindibad.useraccount.port.in.ModifyUserAccountUseCase;
import tech.byrsa.sindibad.useraccount.port.out.GetUserAccount;
import tech.byrsa.sindibad.useraccount.port.out.SaveUserAccount;

@Service
@RequiredArgsConstructor
public class UserAccounetService implements CreateUserAccountUseCase, GetUserAccountUseCase, ModifyUserAccountUseCase {
	private final SaveUserAccount saveUserAccount;
	private final PasswordEncoder passwordEncoder;
	private final GetUserAccount getUserAccount;

	@Override
	public Long createUserAccount(UserAccountCreate userAccountCreate) {
		final String encodedPassword = passwordEncoder.encode(userAccountCreate.getPassword());
        userAccountCreate.setPassword(encodedPassword);
		UserAccount userAccount = saveUserAccount.createUserAccount(userAccountCreate);
		return userAccount.getId();
	}

	@Override
	public UserAccount getUserById(Long id) {
		UserAccount u = getUserAccount.getUserAccountById(id);
		return u;
	}

	@Override
	public UserAccount modifyUserAccountUseCase(Long id, UserAccount userAccount) {
		UserAccount u = getUserAccount.getUserAccountById(id);
		if(u==null) return null;
		u.setFirstname(userAccount.getFirstname());
		u.setLastname(userAccount.getLastname());
		u = saveUserAccount.modifyUserAccount(id, userAccount);
		return u;
	}

	@Override
	@EventListener(ApplicationReadyEvent.class)
	public void createAdmin() {
		System.out.println("hello world, I have just started up");
		UserAccount a = getUserAccount.getUserAccountByEmail("admin");
		if(a == null){
			UserAccountCreate UC = new UserAccountCreate();
			UC.setEmail("admin");
			UC.setFirstname("admin");
			UC.setLastname("admin");
			UC.setPassword("admin");
			Long g = createUserAccount(UC);
			System.out.println("created admin user with id: " + g);
		}
	}
}
