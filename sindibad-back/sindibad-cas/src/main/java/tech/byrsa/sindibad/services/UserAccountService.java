package tech.byrsa.sindibad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tech.byrsa.sindibad.entites.UserAccount;
import tech.byrsa.sindibad.repositories.UserAccountRepository;
@Service
@AllArgsConstructor
public class UserAccountService implements UserDetailsService {

	 @Autowired
	    private final UserAccountRepository userAccountRepository;
	 @Override
	 public UserDetails loadUserByUsername(String email) {
		 UserAccount user = userAccountRepository.findByEmail(email);
	        if (user == null) {
	            throw new UsernameNotFoundException(email);
	        }
	        return new MyUserPrincipal(user);
		 
	 }
	 
}
