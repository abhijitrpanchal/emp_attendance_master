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
	
//	@Bean
//	AttendanceCalculator AttendanceCalculator(){
//		System.out.println("Inside AttendanceCalculatorTest :: AttendanceCalculator method");
//		AttendanceAggregator attendanceAggregator = mock(AttendanceAggregator.class);
//		attendanceCalculator = new AttendanceCalculator(attendanceAggregator);
//		return attendanceCalculator;
//	}
	
	@Before
    public void setUp() {
		//attendanceCalculator= Mockito.mock(AttendanceCalculator.class);;
    }
	
	@Test
	public void getCalculateAttendanceEmployee() throws Exception {
		log.info(" Inside AttendanceCalculatorTest getCalculateAttendanceEmployee");
		Collection<EmployeeAttendance>  employeeAttenance = this.attendanceCalculator.getCalculateAttendanceEmployee(ApplicationTestConstants.EMPLOYEE_ID_TEST_BUSINESS);
		if(null == employeeAttenance){
			log.info("getCalculateAttendanceWithOutEmployeeId : null array returned");
		}
		
	}

}
