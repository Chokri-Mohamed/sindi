package tech.byrsa.sindibad.configuration;

import java.time.Clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfiguration {

	@Bean
    Clock clock() {
		return Clock.systemUTC();
	}
}
