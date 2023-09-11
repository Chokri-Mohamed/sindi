package tech.byrsa.sindibad.adapter.useraccount;

import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tech.byrsa.sindibad.database.entity.UserAccountDb;
import tech.byrsa.sindibad.database.repository.UserAccountRepository;
import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;
import tech.byrsa.sindibad.useraccount.port.out.GetUserAccount;
import tech.byrsa.sindibad.useraccount.port.out.SaveUserAccount;

@XSlf4j
@Component
@RequiredArgsConstructor
public class UserAccountJpaAdapter implements SaveUserAccount, GetUserAccount {

	private final UserAccountJpaAdapterMapper userAccountJpaAdapterMapper;

	private final UserAccountRepository userAccountRepository;

	@Override
	@Transactional
	public UserAccount createUserAccount(UserAccountCreate userAccountCreate) {
		UserAccountDb userAccountDb = userAccountJpaAdapterMapper.map(userAccountCreate);
		userAccountDb = userAccountRepository.save(userAccountDb);
		UserAccount userAccount = userAccountJpaAdapterMapper.map(userAccountDb);
		System.out.println(userAccountCreate.getPassword());
		return userAccount;
	}


	@Override
	public UserAccount modifyUserAccount(Long id, UserAccount userAccount) {
		UserAccountDb userAccountDb = userAccountJpaAdapterMapper.map(userAccount);
		UserAccountDb u = userAccountRepository.findById(id).orElse(null);
		if(u == null) return null;
		u.setFirstname(userAccountDb.getFirstname());
		u.setLastname(userAccountDb.getLastname());
		u = userAccountRepository.save(u);
		return userAccountJpaAdapterMapper.map(u);
	}

	@Override
	public UserAccount getUserAccountById(Long id) {
		UserAccountDb us = userAccountRepository.findById(id).orElse(null);
		UserAccount u = userAccountJpaAdapterMapper.map(us);
		return u;
	}

	@Override
	public UserAccount getUserAccountByEmail(String email) {
		UserAccountDb us = userAccountRepository.findByEmail(email);
		if(us == null) return null;
		return userAccountJpaAdapterMapper.map(us);
	}
}
