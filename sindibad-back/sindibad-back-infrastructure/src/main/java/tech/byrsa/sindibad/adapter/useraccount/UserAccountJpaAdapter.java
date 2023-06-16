package tech.byrsa.sindibad.adapter.useraccount;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tech.byrsa.sindibad.database.entity.UserAccountDb;
import tech.byrsa.sindibad.database.repository.UserAccountRepository;
import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;
import tech.byrsa.sindibad.useraccount.port.out.SaveUserAccount;

@Component
@RequiredArgsConstructor
public class UserAccountJpaAdapter implements SaveUserAccount {

	private final UserAccountJpaAdapterMapper userAccountJpaAdapterMapper;
	private final UserAccountRepository userAccountRepository;

	@Override
	@Transactional
	public UserAccount createUserAccount(UserAccountCreate userAccountCreate) {
		UserAccountDb userAccountDb = userAccountJpaAdapterMapper.map(userAccountCreate);
		UserAccountDb savedUserAccountDb = userAccountRepository.save(userAccountDb);
		UserAccount userAccount = userAccountJpaAdapterMapper.map(savedUserAccountDb);
		return userAccount;
	}

}
