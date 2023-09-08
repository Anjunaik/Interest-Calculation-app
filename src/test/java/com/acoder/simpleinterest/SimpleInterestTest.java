package com.acoder.simpleinterest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.acoder.allpojoclass.DatePojo;
import com.acoder.allpojoclass.SimpleInterestReqPojo;
import com.acoder.allpojoclass.SimpleInterestRespPojo;
import com.acoder.dateservice.DateService;

class SimpleInterestTest {

	@Mock
	private SimpleInterestInf inf;
	
	private SimpleInterest interest;
	
	private SimpleInterestReqPojo reqPojo;
	
	private SimpleInterestRespPojo respPojo;
	
	private DatePojo datePojo;
	
	private DateService dateService;
	
	AutoCloseable autoCloseable;
	
	@BeforeEach
	void setUp() throws Exception {
		
		autoCloseable=MockitoAnnotations.openMocks(this);
		respPojo=new SimpleInterestRespPojo();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void testSimpleInterestCalculation1() throws Exception {
		//fail("Not yet implemented");
		//setting request body
		reqPojo= new SimpleInterestReqPojo
				(new Date(System.currentTimeMillis()),
						new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(256)), 
						10000.00, 
					    3.0, 
						"yearly");
		
								
				//create simple interest class object
				interest=new SimpleInterest();
				//creating Date pojo class object for hold years,day, months 
				datePojo= new DatePojo();
				
				//creating object for DataService class for Calculate Years,months,days
				dateService= new DateService();
				//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
				
				//interest calculation
				interest.simpleInterestCalculation(reqPojo, datePojo,respPojo);
		
	  assertThat(respPojo.getPerDay()).isNotEqualTo(null);
	  assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
	  assertThat(respPojo.getPerYear()).isNotEqualTo(null);
	
	
	 
	}
	
	@Test
	void testSimpleInterestCalculation2() throws Exception {
		reqPojo= new SimpleInterestReqPojo
				(new Date(System.currentTimeMillis()),
						new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(365)), 
						10000.00, 
					    3.0, 
						"monthly");
		
			
				//create simple interest class object
				interest=new SimpleInterest();
				//creating Date pojo class object for hold years,day, months 
				datePojo= new DatePojo();
				
				//creating object for DataService class for Calculate Years,months,days
				dateService= new DateService();
				//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
				
				//interest calculation
				interest.simpleInterestCalculation(reqPojo, datePojo,respPojo);
		
	  assertThat(respPojo.getPerDay()).isNotEqualTo(null);
	  assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
	  assertThat(respPojo.getPerYear()).isNotEqualTo(null);
	
	 
	}
	
	
	
	@Test
	void testSimpleInterestCalculation4() throws Exception {
		reqPojo= new SimpleInterestReqPojo
				(new Date(System.currentTimeMillis()),
						new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(567)), 
						10000.00, 
					    3.0, 
						"monthly");
		
			
				//create simple interest class object
				interest=new SimpleInterest();
				//creating Date pojo class object for hold years,day, months 
				datePojo= new DatePojo();
				
				//creating object for DataService class for Calculate Years,months,days
				dateService= new DateService();
				//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
				
				//interest calculation
				interest.simpleInterestCalculation(reqPojo, datePojo,respPojo);
		
	  assertThat(respPojo.getPerDay()).isNotEqualTo(null);
	  assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
	  assertThat(respPojo.getPerYear()).isNotEqualTo(null);
	
	 
	}
	
	
	@Test
	void testSimpleInterestCalculation3() throws Exception {
		//fail("Not yet implemented");
		//setting request body
		reqPojo= new SimpleInterestReqPojo
				(new Date(System.currentTimeMillis()),
						new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(365)), 
						10000.00, 
					    null, 
						"monthly");
		
				//System.out.println("Start date"+reqPojo.getStartDate()+":::Ends Date"+reqPojo.getEndsDate());
				
				//create simple interest class object
				interest=new SimpleInterest();
				//creating Date pojo class object for hold years,day, months 
				datePojo= new DatePojo();
				
				dateService= new DateService();
				//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
				//interest calculation
				//interest.simpleInterestCalculation(reqPojo, datePojo);
		
				assertThrows(NullPointerException.class,
			            ()->interest.simpleInterestCalculation(reqPojo, datePojo,respPojo));	
	
	 
	}
	
	@Test
	void testSimpleInterestCalculation5() throws Exception {
		reqPojo= new SimpleInterestReqPojo
				(new Date(System.currentTimeMillis()),
						new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(567)), 
						10000.00, 
					    3.0, 
						"yearly");
		
			
				//create simple interest class object
				interest=new SimpleInterest();
				//creating Date pojo class object for hold years,day, months 
				datePojo= new DatePojo();
				
				//creating object for DataService class for Calculate Years,months,days
				dateService= new DateService();
				//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
				
				//interest calculation
				interest.simpleInterestCalculation(reqPojo, datePojo,respPojo);
		
	  assertThat(respPojo.getPerDay()).isNotEqualTo(null);
	  assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
	  assertThat(respPojo.getPerYear()).isNotEqualTo(null);
	
	 
	}
	

}
