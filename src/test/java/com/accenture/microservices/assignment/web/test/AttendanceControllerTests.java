package com.accenture.microservices.assignment.web.test;



import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.accenture.microservices.emp.attendance.data.EmployeeAttendance;
import com.accenture.microservices.emp.attendance.test.business.ApplicationTestConstants;
import com.accenture.microservices.emp.attendance.web.AttendanceController;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = AttendanceController.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AttendanceControllerTests {
	
	public static final Logger log = LoggerFactory.getLogger(AttendanceControllerTests.class);
	
	@MockBean
	AttendanceController attendanceController;
   
	@Before
    public void setup() throws Exception {
        
    }
    /**
     * 
     * @throws Exception
     * @Description: positive test case- Unit test with parameter employeeId
     * @param: employeeId
     * @return: EmployeeAttendance
     * @expected result: Employee attendance document
     * 
     */
	@Test
	public void getCalculateAttendanceEmployee() throws Exception {
		Integer employeeId = ApplicationTestConstants.EMPLOYEE_ID_TEST_BUSINESS;
		Collection<EmployeeAttendance> employeeAttendance = attendanceController.getEmployeeAttendance(employeeId);
		if(null == employeeAttendance){
			log.info("getCalculateAttendanceEmployee: "+employeeAttendance.toString());
		}
		
	}

	/**
	 * 
	 * @throws Exception
	 * @Description: negative test case- Unit Test with out employeeId
	 * @param: null
     * @return: EmployeeAttendance
     * @expected result: Employee attendance document with null Arraylist
	 */
	@Test
	public void getCalculateAttendanceWithOutEmployeeId() throws Exception {
		log.info(" Inside getCalculateAttendanceWithOutEmployeeId");
		Collection<EmployeeAttendance> employeeAttendance = attendanceController.getEmployeeAttendance(null);
		if(null == employeeAttendance){
			log.info("getCalculateAttendanceEmployeeJsonCheck: "+employeeAttendance.toString());
		}
		
	}


}
