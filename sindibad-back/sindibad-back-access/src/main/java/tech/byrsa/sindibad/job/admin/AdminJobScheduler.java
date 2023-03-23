package tech.byrsa.sindibad.job.admin;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

@XSlf4j
@Component
@AllArgsConstructor
public class AdminJobScheduler {

	@Scheduled(cron = "0 0 1 * * *")
	@SchedulerLock(name = "exampleAdmin", lockAtLeastFor = "PT30M")
	void deleteDisabledToken() {
		log.info("START ADMIN JWT JOB");
		// TODO CRON JOB
		log.info("END ADMIN JWT JOB");
	}
}
