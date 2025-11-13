package net.ironoc.cron.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.ironoc.cron.service.FileService;

@Component
public class FileFeedJob {

	private final FileService fileService;

    @Autowired
    public FileFeedJob(FileService fileService) {
        this.fileService = fileService;
    }

    @Scheduled(fixedDelay = 10000) // every 10 secs and does NOT wait for last execution to finish
//	@Scheduled(cron = "0 45 9 * * MON-FRI") // mon to fri at 945am
//	@Scheduled(cron = "${cron.job.time}") // externalize job time...
//	@Scheduled(cron = "*/7 * * * * *") // every 7 seconds
//	@Scheduled(fixedRate = 10000) // every 10 secs and waits for last execution to finish
	public void execute() {
		fileService.readFileLineByLine();
	}
}
