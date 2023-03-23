package tech.byrsa.sindibad.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;
import tech.byrsa.sindibad.rest.handler.ErrorMessageAccessDeniedHandler;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

	private final ErrorMessageAccessDeniedHandler accessDeniedHandler;

	@Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
    SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/**").authenticated()
		.and()
		.oauth2ResourceServer().jwt()
        .and()
        .accessDeniedHandler(accessDeniedHandler)
        .and()
        .csrf().disable()
        .httpBasic().disable();

		return http.build();
	}

//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//		return web -> web.ignoring().antMatchers("/ignore1", "/ignore2");
//	}
}