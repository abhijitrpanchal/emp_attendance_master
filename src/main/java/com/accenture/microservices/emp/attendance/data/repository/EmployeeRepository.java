/**
 * 
 */
package com.accenture.microservices.emp.attendance.data.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;

import com.accenture.microservices.emp.attendance.data.EmployeeAttendance;

/**
 * @author j.venugopalan
 *
 */
public interface EmployeeRepository extends CrudRepository<EmployeeAttendance, String>{
	
	@View(designDocument = "byEmployeeId", viewName = "byEmployeeId")
	 List<EmployeeAttendance> findByEmployeeId(Integer employeeId);
}
