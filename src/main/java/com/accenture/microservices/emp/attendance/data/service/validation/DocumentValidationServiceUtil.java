/**
 * 
 */
package com.accenture.microservices.emp.attendance.data.service.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.microservices.emp.attendance.data.DayAttendance;
import com.accenture.microservices.emp.attendance.data.EmployeeAttendance;
import com.accenture.microservices.emp.attendance.data.service.AttendanceService;

/**
 * @author j.venugopalan
 *
 */
@Service
public class DocumentValidationServiceUtil {
	
	public DocumentValidationServiceUtil() {
		System.out.println("Inside DocumentValidationServiceUtil Constructor");
		// TODO Auto-generated constructor stub
	}
	@Autowired
	AttendanceService attendanceService;
	
	public void compareArrayList(){
		//Integer employeeId1 = 1266;
		Collection<EmployeeAttendance> employeeAttance1 = attendanceService.getEmployeeAttendance(1268);
		Collection<EmployeeAttendance> employeeAttance2= attendanceService.getEmployeeAttendance(1269);
		Collection<DayAttendance> dayAttendance1 = new ArrayList<DayAttendance>();
		Collection<DayAttendance> dayAttendance2= new ArrayList<DayAttendance>();
		for(EmployeeAttendance ea : employeeAttance1){
			dayAttendance1 = ea.getDayAttendance();
		}
		for(EmployeeAttendance ea : employeeAttance2){
			dayAttendance2 = ea.getDayAttendance();
		}
		System.out.println(dayAttendance2.equals(dayAttendance1)+ " ::: compare");
		
	}
}
