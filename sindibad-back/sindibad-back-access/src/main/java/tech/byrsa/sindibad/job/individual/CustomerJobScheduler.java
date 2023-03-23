package tech.byrsa.sindibad.job.individual;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

@XSlf4j
@Component
@AllArgsConstructor
public class CustomerJobScheduler {

	@Scheduled(cron = "0 0 1 * * *")
	@SchedulerLock(name = "exampleIndividual", lockAtLeastFor = "PT30M")
	void deleteDisabledToken() {
		log.info("START INDIVIDUAL JOB");
		// TODO CRON JOB
		log.info("END INDIVIDUAL JOB");
	}
}
