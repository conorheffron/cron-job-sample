package com.test.cron.job;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldJob {
	
	private String timeStamp;
	
//	@Scheduled(fixedDelay = 10000) // every 10 secs and does NOT wait for last execution to finish
//	@Scheduled(cron = "0 45 9 * * MON-FRI") // mon to fri at 945am
//	@Scheduled(cron = "${cron.job.time}") // externalize job time...
//	@Scheduled(cron = "*/7 * * * * *") // every 7 seconds
	
	@Scheduled(fixedRate = 7000) // every 7 secs and waits for last execution to finish
	public void execute() {
		Calendar calendar = Calendar.getInstance();
		Date currentTime = calendar.getTime();
		Timestamp currentTimestamp = new Timestamp(currentTime.getTime());
		
		this.setTimeStamp(currentTimestamp.toString());
		
		System.out.println("Test time job executed @: " + this.getTimeStamp());
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String name) {
		this.timeStamp = name;
	}

}
