package com.accenture.microservices.emp.attendence;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * Test class for {@link attendanceController}
 *
 * @author mahima.agarwal
 */
public class AttendanceControllerTest {

//	@Autowired
//	private AttendanceController attendanceController;
	
	 @Autowired
	 private SimpleMappingExceptionResolver simpleMappingExceptionResolver;

	 
	 @Autowired
	 private WebApplicationContext webApplicationContext;
	 
	 private MockMvc mockMvc;
	 
	@Before
	public void setUp() throws Exception {
		//this.mockMvc = MockMvcBuilders.standaloneSetup(attendanceController).build();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testAttendanceCalculator() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeeAttendanceInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployeeAttance() {
		fail("Not yet implemented");
	}

	
}
