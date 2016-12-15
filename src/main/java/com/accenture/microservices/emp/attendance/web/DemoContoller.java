package com.accenture.microservices.emp.attendance.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoContoller {
	
	@RequestMapping("/")
	public String getMessage(){
		return "Welcome to Employee Attendance microservice ";
	}
	
	@RequestMapping("/home/{name}")
	public String greetUser(@PathVariable("name") String username){
		return "Welcome to Spring boot Controller " + username;
	}
	

}
