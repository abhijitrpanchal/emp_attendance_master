/**
 * 
 */
package com.accenture.microservices.emp.attendance.business;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.accenture.microservices.emp.attendance.data.AttendanceAggregator;
import com.accenture.microservices.emp.attendance.data.EmployeeAttendance;


/**
 * @author j.venugopalan
 *
 */

@SpringBootApplication
@Component
@Service
public class AttendanceCalculator {
	public static final Logger log = LoggerFactory.getLogger(AttendanceCalculator.class);
	
	public AttendanceCalculator(){
		log.debug("Inside AttendanceCalculator constructor");
	}
	
	
	 
	
	@Autowired
	AttendanceAggregator attendanceAggregator;
	
	@Bean
	AttendanceAggregator attendanceAggregator(){
		System.out.println("Inside AttendanceCalculator :: attendanceAggregator method");
		return new AttendanceAggregator();
	}


	
	public Collection<EmployeeAttendance> getCalculateAttendanceEmployee(Integer empId){
		log.info("Emp ID passed ::" + empId);
		Collection<EmployeeAttendance>  employeeAttenance = this.attendanceAggregator.getEmployeeAttendance(empId);
		return  employeeAttenance;
	}
	
	public Collection<EmployeeAttendance> getCalculateAttendanceEmployees(){
		Collection<EmployeeAttendance>  employeesAttenance = this.attendanceAggregator.getAllEmployeesAttendance();
		return  employeesAttenance;
	}
	public Boolean submitEmployeeAttendanceWeb(EmployeeAttendance employeeAttendance){
		Boolean status = this.attendanceAggregator.submitEmployeeAttenanceDomain(employeeAttendance);
		return status;
	}
	public Boolean deleteEmployeeAttandance(EmployeeAttendance employeeAttendance){
		this.attendanceAggregator.deleteEmployeeAttenance(employeeAttendance);
		return null;
	}
	

}
