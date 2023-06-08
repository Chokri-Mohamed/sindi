package tech.byrsa.sindibad.config;

import java.time.Clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity

public class ClockConfiguration {
	
	@Bean
	public Clock clock() {
		return Clock.systemUTC();
	}

}