package com.accenture.microservices.emp.attendance;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import com.accenture.microservices.emp.attendance.web.AttendanceController;

//@Component
//@Service
//@EnableAutoConfiguration
//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com.accenture.microservices"})
//@SpringBootApplication(scanBasePackages = { "com.accenture.microservices.emp.data"})

public class EmpAttendanceMasterApplication { // extends SpringBootServletInitializer{
	
	private static final Logger log = LoggerFactory.getLogger(EmpAttendanceMasterApplication.class);

//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(EmpAttendanceMasterApplication.class);
//    }
//	@Autowired
//	private AttendanceController attendanceController ;

	public static void main(String[] args) {
		System.out.println("Let's inspect the beans provided by Spring Boot");
		ApplicationContext ctx = SpringApplication.run(EmpAttendanceMasterApplication.class, args);
		
			
					log.info("Let's inspect the beans provided by Spring Boot:" + ctx.toString());
					//Getting all the Bean names from ApplicationContext
					
					String[] beanNames = ctx.getBeanDefinitionNames();
					int beanNumber = 0;
					Arrays.sort(beanNames);
					for (String beanName : beanNames) {
						beanNumber++;
						log.info("Bean number: "+beanNumber+": "+beanName);
					} 
					AttendanceController attendanceController = new AttendanceController();
					
//					Collection<EmployeeAttendance> employeeAttendance = attendanceController.getEmployeeAttendance(new Integer(1233));
//					if (null!= employeeAttendance)
//						log.info("employeeAttendance collection: "+employeeAttendance.toString());
					
	}
}
