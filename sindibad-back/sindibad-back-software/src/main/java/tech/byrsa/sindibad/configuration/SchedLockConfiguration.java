package tech.byrsa.sindibad.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;

@Configuration
public class SchedLockConfiguration {

	@Bean
    LockProvider lockProvider(final DataSource dataSource) {
		return new JdbcTemplateLockProvider(
				JdbcTemplateLockProvider.Configuration.builder()
				.withJdbcTemplate(new JdbcTemplate(dataSource))
				// Works on Postgres, MySQL, MariaDb, MS SQL, Oracle, DB2, HSQL and H2
				.usingDbTime()
				.build());
	}
}
