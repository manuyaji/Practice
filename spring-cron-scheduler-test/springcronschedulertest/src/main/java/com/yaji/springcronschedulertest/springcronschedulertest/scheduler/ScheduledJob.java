package com.yaji.springcronschedulertest.springcronschedulertest.scheduler;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class ScheduledJob implements Runnable{

	public void run() {
		System.out.println("Hello WOrld!!");
		System.out.println(Calendar.getInstance().getTime());
	}

}
