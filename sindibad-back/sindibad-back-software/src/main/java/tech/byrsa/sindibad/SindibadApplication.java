package tech.byrsa.sindibad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;

@EnableCaching
@EnableScheduling

@EnableSchedulerLock(defaultLockAtMostFor = "PT1H")

@EntityScan("tech.byrsa.sindibad.*")

@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories("tech.byrsa.sindibad.database.repository")
public class SindibadApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SindibadApplication.class, args);
	}

}
