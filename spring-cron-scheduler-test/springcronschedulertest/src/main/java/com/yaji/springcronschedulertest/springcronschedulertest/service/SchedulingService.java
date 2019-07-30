package com.yaji.springcronschedulertest.springcronschedulertest.service;

import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.yaji.springcronschedulertest.springcronschedulertest.scheduler.ScheduledJob;
import com.yaji.springcronschedulertest.springcronschedulertest.state.State;

@Component
public class SchedulingService implements InitializingBean{
	
	@Autowired
	private State state;
	
	/*@Autowired
	ScheduledTaskRegistrar scheduledTaskRegistrar;*/
	
	/*@Autowired
	private DynamicSchedulingConfigurer schedulingConfigurer;*/
	
	@Autowired
	private TaskScheduler taskScheduler;
	
	@Autowired
	private ScheduledJob job;
	
	private ScheduledFuture scheduledFuture;
	
	public void rescheduleJob(String cronExpression){
		scheduledFuture.cancel(false);
		state.setCronExpression(cronExpression);
		scheduleJob();
	}
	
	public void scheduleJob(){
		scheduledFuture = taskScheduler.schedule(job, new CronTrigger(state.getCronExpression()));
	}
	
	public String getCronExpression(){
		return state.getCronExpression();
	}
	
	public void afterPropertiesSet(){
		scheduleJob();
	}

}
