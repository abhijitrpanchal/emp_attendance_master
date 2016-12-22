package com.accenture.microservices.emp.attendance.test.business;

import static org.mockito.Mockito.mock;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accenture.microservices.emp.attendance.business.AttendanceCalculator;
import com.accenture.microservices.emp.attendance.data.AttendanceAggregator;
import com.accenture.microservices.emp.attendance.data.EmployeeAttendance;



@SpringBootTest (classes = AttendanceCalculator.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = AttendanceCalculator.class)
public class AttendanceCalculatorTest {	
	public static final Logger log = LoggerFactory.getLogger(AttendanceCalculatorTest.class);
	
	@MockBean 
	private AttendanceCalculator attendanceCalculator ;
	

	
	@Before
    public void setUp() {
		//attendanceCalculator= Mockito.mock(AttendanceCalculator.class);;
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
		log.info(" Inside AttendanceCalculatorTest getCalculateAttendanceEmployee");
		Collection<EmployeeAttendance>  employeeAttenance = this.attendanceCalculator.getCalculateAttendanceEmployee(ApplicationTestConstants.EMPLOYEE_ID_TEST_BUSINESS);
		if(null == employeeAttenance){
			log.info("getCalculateAttendanceWithOutEmployeeId : null array returned");
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
	public void testEmployeeAttendanceNegative() throws Exception {
		log.info(" Inside AttendanceCalculatorTest getCalculateAttendanceEmployee");
		Collection<EmployeeAttendance>  employeeAttenance = this.attendanceCalculator.getCalculateAttendanceEmployee(null);
		if(null == employeeAttenance){
			log.info("getCalculateAttendanceWithOutEmployeeId : null array returned");
		}
		
	}
	

}
