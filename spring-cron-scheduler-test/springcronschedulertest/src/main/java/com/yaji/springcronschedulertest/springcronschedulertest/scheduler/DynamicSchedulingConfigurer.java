/*package com.yaji.springcronschedulertest.springcronschedulertest.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.yaji.springcronschedulertest.springcronschedulertest.state.State;

@Configuration
@Component
public class DynamicSchedulingConfigurer implements SchedulingConfigurer{
	
	@Autowired
	private ScheduledJob job;
	
	@Autowired
	private State state;

	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		TaskScheduler taskScheduler = scheduledTaskRegistrar.getScheduler();
		taskScheduler.schedule(job, new CronTrigger(state.getCronExpression()));
	}

}*/
