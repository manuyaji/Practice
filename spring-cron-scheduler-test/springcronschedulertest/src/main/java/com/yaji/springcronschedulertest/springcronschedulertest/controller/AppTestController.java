package com.yaji.springcronschedulertest.springcronschedulertest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yaji.springcronschedulertest.springcronschedulertest.service.SchedulingService;

@RestController
@RequestMapping(path="/app")
public class AppTestController {
	
	@Autowired
	private SchedulingService schedulingService;
	
	@RequestMapping(path="/schedule", method=RequestMethod.POST)
	public ResponseEntity<String> changeSchedule(@RequestParam String cronExpression){
		schedulingService.rescheduleJob(cronExpression);
		return new ResponseEntity<String>("Rescheduled to "+cronExpression, HttpStatus.OK);
	}
	
	@RequestMapping(path="/cron", method=RequestMethod.GET)
	public ResponseEntity<String> getCurrentCronExpression(@RequestParam(defaultValue="") List<String> strs){
		System.out.println(strs);
		return new ResponseEntity<String>(schedulingService.getCronExpression(), HttpStatus.OK);
	}
	
}
