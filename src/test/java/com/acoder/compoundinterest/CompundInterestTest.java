package com.acoder.compoundinterest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.acoder.allpojoclass.CompoundReqPojo;
import com.acoder.allpojoclass.CompoundResPojo;
import com.acoder.allpojoclass.DatePojo;
import com.acoder.dateservice.DateService;

class CompundInterestTest {
	
@Mock
private CompoundInterestInf inf;

private CompundInterest interest;

private CompoundReqPojo reqPojo;

private CompoundResPojo respPojo;

private DatePojo datePojo;

private DateService dateService;

AutoCloseable autoCloseable;

	@BeforeEach
	void setUp() throws Exception {
		

		 autoCloseable = MockitoAnnotations.openMocks(this);
		 
		//creating Date pojo class object for hold years,day, months 
			datePojo= new DatePojo();
			
			//creating object for DataService class for Calculate Years,months,days
			dateService= new DateService();
		respPojo= new CompoundResPojo();
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void testCompoundInterestCal1() throws Exception {
		//entering user data 
		reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(400)), 
				10000.00, 3.0, "yearly", "annually");
		
		//creating calculation class object
		interest= new CompundInterest();
		
		
		//Dates calculations
		dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
		
		//interest calculation
		interest.compoundInterestCal(reqPojo, datePojo,respPojo);

	
  assertThat(respPojo.getPerDay()).isNotEqualTo(null);
  assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
  assertThat(respPojo.getPerYear()).isNotEqualTo(null);
  
  System.out.println("\n");
  reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
			new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(300)), 
			10000.00, 3.0, "yearly", "annually");
	
	//creating calculation class object
	interest= new CompundInterest();
	
	
	//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
	
	//interest calculation
	interest.compoundInterestCal(reqPojo, datePojo,respPojo);

	
assertThat(respPojo.getPerDay()).isNotEqualTo(null);
assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
assertThat(respPojo.getPerYear()).isNotEqualTo(null);

	}

	@Test
	//semi annually calculation
	void testCompoundInterestCal2() throws Exception {
		//entering user data 
		reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(400)), 
				10000.00, 3.0, "yearly", "semiannually");
		
		//creating calculation class object
		interest= new CompundInterest();
		
		
		//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
		//interest calculation
		interest.compoundInterestCal(reqPojo, datePojo,respPojo);
		/*
		 * System.out.println(datePojo.toString());
		 * System.out.println(reqPojo.toString()); Syst
		 */
  assertThat(respPojo.getPerDay()).isNotEqualTo(null);
  assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
  //assertThat(respPojo.getPerYear()).isNotEqualTo(null);
  
  reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
			new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(10)), 
			10000.00, 3.0, "yearly", "semiannually");
	
	//creating calculation class object
	interest= new CompundInterest();
	
	
	//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
	
	//interest calculation
	interest.compoundInterestCal(reqPojo, datePojo,respPojo);

assertThat(respPojo.getPerDay()).isNotEqualTo(null);
assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
//assertThat(respPojo.getPerYear()).isNotEqualTo(null);

	}

	@Test
	//quarterly calculation
	void testCompoundInterestCal3() throws Exception {
		//entering user data 
		reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(400)), 
				10000.00, 3.0, "yearly", "quarterly");
		
		//creating calculation class object
		interest= new CompundInterest();
		
		
		//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
		//interest calculation
		interest.compoundInterestCal(reqPojo, datePojo,respPojo);

		
  assertThat(respPojo.getPerDay()).isNotEqualTo(null);
  assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
  //assertThat(respPojo.getPerYear()).isNotEqualTo(null);

  reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
			new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(2)), 
			10000.00, 3.0, "yearly", "quarterly");
	
	
	
//Dates calculations
		dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
	//creating calculation class object
	interest= new CompundInterest();
	//interest calculation
	interest.compoundInterestCal(reqPojo, datePojo,respPojo);

	
assertThat(respPojo.getPerDay()).isNotEqualTo(null);
assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
//assertThat(respPojo.getPerYear()).isNotEqualTo(null);

	}
	
	@Test
	//monthly calculation
	void testCompoundInterestCal4() throws Exception {
		//entering user data 

		reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(1000)), 
				10000.00, 3.0, "yearly", "monthly");
	
		
		
		//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);

		//creating calculation class object
		interest= new CompundInterest();
		//interest calculation
		interest.compoundInterestCal(reqPojo, datePojo,respPojo);

		
  assertThat(respPojo.getPerDay()).isNotEqualTo(null);
  assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
  assertThat(respPojo.getPerYear()).isNotEqualTo(null);

  
  
	reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
			new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(20)), 
			10000.00, 3.0, "yearly", "monthly");

	
	
	//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
	

	//creating calculation class object
	interest= new CompundInterest();
	//interest calculation
	interest.compoundInterestCal(reqPojo, datePojo,respPojo);
	
assertThat(respPojo.getPerDay()).isNotEqualTo(null);
assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
assertThat(respPojo.getPerYear()).isNotEqualTo(null);


reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
		new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(100)), 
		10000.00, 3.0, "yearly", "monthly");



//Dates calculations
		dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);

//creating calculation class object
interest= new CompundInterest();
//interest calculation
interest.compoundInterestCal(reqPojo, datePojo,respPojo);


assertThat(respPojo.getPerDay()).isNotEqualTo(null);
assertThat(respPojo.getPerMonth()).isNotEqualTo(null);
assertThat(respPojo.getPerYear()).isNotEqualTo(null);



  }
	@Test
	//monthly calculation
	void testCompoundInterestCal5() throws Exception {
		//entering user data 

		reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(500)), 
				10000.00, null, "monthly", "monthly");
		//creating calculation class object
		interest= new CompundInterest();
		
		
		//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
		
		assertThrows(NullPointerException.class, ()->interest.compoundInterestCal(reqPojo, datePojo,respPojo));

  
	reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
			new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(20)), 
			null, 3.0, "monthly", "monthly");
	//creating calculation class object
	interest= new CompundInterest();
	
	
	//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
	
	assertThrows(NullPointerException.class, ()->interest.compoundInterestCal(reqPojo, datePojo,respPojo));
	 
	 }
	

	
}
