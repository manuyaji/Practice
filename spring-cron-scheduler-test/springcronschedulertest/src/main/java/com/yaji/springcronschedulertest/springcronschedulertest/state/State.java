package com.yaji.springcronschedulertest.springcronschedulertest.state;

import org.springframework.stereotype.Component;

@Component
public class State {
	
	private String cronExpression="*/3 * * * * *";

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

}
