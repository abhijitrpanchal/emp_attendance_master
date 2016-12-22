package com.accenture.microservices.emp.attendance.test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.accenture.microservices.emp.attendance.EmpAttendanceMasterApplication;
import com.accenture.microservices.emp.attendance.test.business.ApplicationTestConstants;


@SpringBootTest (classes = EmpAttendanceMasterApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EmpAttendanceMasterApplicationTests {
	
	public static final Logger log = LoggerFactory.getLogger(EmpAttendanceMasterApplicationTests.class);
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	private MockMvc mockMvc;
    
	private HttpMessageConverter mappingJackson2HttpMessageConverter;
    
	@Autowired
    private WebApplicationContext webApplicationContext;
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
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
	public void getEmployeeAttendance() throws Exception {
		log.info("Result::: "+mockMvc.perform(get("/employee/attendance/1233")));
		MvcResult result = mockMvc.perform(get("/employee/attendance/1233")).andReturn();
		log.info(result.getResponse().getContentAsString());
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
		MvcResult result = mockMvc.perform(get("/employee/attendance/")).andReturn();
		if(result.getResponse().getContentAsString() == null){
			log.info("getCalculateAttendanceWithOutEmployeeId : null array returned");
		}
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
	public void getCalculateAttendanceEmployeeJsonCheck() throws Exception {
		log.info(" Inside getCalculateAttendanceEmployeeJsonCheck");
		Integer employeeId = ApplicationTestConstants.EMPLOYEE_ID_TEST_BUSINESS;
		mockMvc.perform(get("/employee/attendance/"+employeeId)).andExpect(status().isOk())
		.andDo(print())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.[0].employeeId", is(employeeId)));
	}
	
	protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

}
