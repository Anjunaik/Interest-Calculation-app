package com.acoder.interestrestcontroller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.acoder.allpojoclass.CompoundReqPojo;
import com.acoder.allpojoclass.CompoundResPojo;
import com.acoder.allpojoclass.SimpleInterestReqPojo;
import com.acoder.allpojoclass.SimpleInterestRespPojo;
import com.acoder.restservice.RestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = InterestController.class)
class InterestControllerTest {

	@Autowired
	MockMvc mvc;
	
	@Autowired
	ObjectMapper mapper;
	
	private SimpleInterestReqPojo interestReqPojo;
	
	private CompoundResPojo compoundResPojo;
	
	private CompoundReqPojo compoundReqPojo;
	
	private  SimpleInterestRespPojo  interestRespPojo;
	
	
	@MockBean
	private RestService restService;
	
	 AutoCloseable autoCloseable;
	@BeforeEach
	void setUp() throws Exception {
		
		
		
		interestReqPojo= new SimpleInterestReqPojo();
		interestRespPojo= new SimpleInterestRespPojo();
		autoCloseable = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		autoCloseable.close();
	}

	@Test
	void testSimpleInterest() throws JsonProcessingException, Exception {
		//fail("Not yet implemented");
		
		interestReqPojo.setStartDate(new Date(System.currentTimeMillis()));
		interestReqPojo.setEndsDate(new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(366)));
		interestReqPojo.setPrincipal(10000.00);
		interestReqPojo.setInterestRate(null);
		interestReqPojo.setRatetype("yearly");
		
		//Then
		when(restService.simpleInterest(interestReqPojo)).thenReturn(interestRespPojo);
		
		 this.mvc.perform(post("/simple")
						.contentType(MediaType.APPLICATION_JSON)
		                .content(mapper.writeValueAsString(interestReqPojo))
						)
				.andDo(print())
				.andExpect(status().isOk());	
		
	}

	@Test
	void testCompoundInterest() throws Exception {
		//fail("Not yet implemented");
		//Given
		compoundReqPojo  = new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(400)), 
				10000.00, 3.0, "yearly", "annually");
		//when
		when(restService.compoundInterest(compoundReqPojo)).thenReturn(compoundResPojo);
		
		//then
	        
		this.mvc.perform(post("/compound")
				.contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(interestReqPojo))
				)
		.andDo(print())
		.andExpect(status().isOk());	
	}

}
