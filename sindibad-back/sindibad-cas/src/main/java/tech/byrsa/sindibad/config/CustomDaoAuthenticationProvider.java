package tech.byrsa.sindibad.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import tech.byrsa.sindibad.entites.UserAccount;

public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {
	@Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	        try{
	            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) super.authenticate(authentication);
	            UserAccount userAccount= (UserAccount) usernamePasswordAuthenticationToken.getPrincipal();
	        
	            return usernamePasswordAuthenticationToken;
	        } catch(Exception exception) {
	        	System.out.println("A");
	        	return null;
	        }
	        finally {
	            
	        }
	     }
}