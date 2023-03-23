package tech.byrsa.sindibad.configuration;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

	@Bean
    AuditorAware<String> auditorProvider() {
		return () -> {
			final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null) {
				return Optional.of("NO_AUTH");
			}
			return Optional.ofNullable(authentication.getName());
		};
	}
}