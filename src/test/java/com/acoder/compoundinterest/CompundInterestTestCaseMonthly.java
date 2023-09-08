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

class CompundInterestTestCaseMonthly {

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
					10000.00, 3.0, "monthly", "annually");
			
			
			
			
			//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);

			//creating calculation class object
			interest= new CompundInterest();
			//interest calculation
			interest.compoundInterestCal(reqPojo, datePojo,respPojo);
				
			  assertThat(respPojo.getPerDay()).isEqualTo(13.6);
			  assertThat(respPojo.getPerMonth()).isEqualTo(408.00); //
			  assertThat(respPojo.getPerYear()).isEqualTo(3600.00);
			  assertThat(respPojo.getInterestTotalAmount()).isEqualTo(4062.4);
			  assertThat(respPojo.getTotalAmount()).isEqualTo(14062.4);
			 
			
	
	  reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(300)), 
				10000.00, 3.0, "monthly", "annually");
		
		
		
		
	//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);

		//creating calculation class object
		interest= new CompundInterest();
		//interest calculation
		interest.compoundInterestCal(reqPojo, datePojo,respPojo);

		
		  assertThat(respPojo.getPerDay()).isEqualTo(10.00);
		  assertThat(respPojo.getPerMonth()).isEqualTo(300.00); //
		  assertThat(respPojo.getPerYear()).isEqualTo(3600.00);
		  assertThat(respPojo.getInterestTotalAmount()).isEqualTo(2960.00);
		  assertThat(respPojo.getTotalAmount()).isEqualTo(12960.00);
		 
		}

		@Test
		//semi annually calculation
		void testCompoundInterestCal2() throws Exception {
			//entering user data 
			reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
					new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(400)), 
					10000.00, 3.0, "monthly", "semiannually");
			
		
			
			
			//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
			

			//creating calculation class object
			interest= new CompundInterest();
			//interest calculation
			interest.compoundInterestCal(reqPojo, datePojo,respPojo);
			
			//System.out.println(respPojo.toString());

			 assertThat(respPojo.getPerDay()).isEqualTo(15.18);
			  assertThat(respPojo.getPerMonth()).isEqualTo(455.31);
			  assertThat(respPojo.getPerYear()).isEqualTo(3924.00);
			  assertThat(respPojo.getInterestTotalAmount()).isEqualTo(4440.03);
			  assertThat(respPojo.getTotalAmount()).isEqualTo(14440.03);
	  
	  reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(10)), 
				10000.00, 3.0, "monthly", "semiannually");
		
		
	//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
		//creating calculation class object
		interest= new CompundInterest();
		//interest calculation
		interest.compoundInterestCal(reqPojo, datePojo,respPojo);

		//System.out.println(respPojo.toString());
		 assertThat(respPojo.getPerDay()).isEqualTo(10.9);
		  assertThat(respPojo.getPerMonth()).isEqualTo(327.00);
		  //assertThat(respPojo.getPerYear()).isEqualTo(3600.00);
		  assertThat(respPojo.getInterestTotalAmount()).isEqualTo(109.0);
		  assertThat(respPojo.getTotalAmount()).isEqualTo(10109.0);

		}

		@Test
		//quarterly calculation
		void testCompoundInterestCal3() throws Exception {
			//entering user data 
			reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
					new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(400)), 
					10000.00, 3.0, "monthly", "quarterly");
			
			
			
			
			//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);

			//creating calculation class object
			interest= new CompundInterest();
			//interest calculation
			interest.compoundInterestCal(reqPojo, datePojo,respPojo);
			
			//System.out.println(respPojo.toString());
			
			assertThat(respPojo.getPerDay()).isEqualTo(16.14);
			  assertThat(respPojo.getPerMonth()).isEqualTo(484.15);
			  //assertThat(respPojo.getPerYear()).isEqualTo(3600.00);
			  assertThat(respPojo.getInterestTotalAmount()).isEqualTo(4664.53);
			  assertThat(respPojo.getTotalAmount()).isEqualTo(14664.53);

	  reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(2)), 
				10000.00, 3.0, "monthly", "quarterly");
		
		
		
		

		//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
		//creating calculation class object
		interest= new CompundInterest();
		//interest calculation
		interest.compoundInterestCal(reqPojo, datePojo,respPojo);
		
		System.out.println(respPojo.toString());
		 
		assertThat(respPojo.getPerDay()).isEqualTo(11.43);
		  assertThat(respPojo.getPerMonth()).isEqualTo(342.98);
		  //assertThat(respPojo.getPerYear()).isEqualTo(3600.00);
		  assertThat(respPojo.getInterestTotalAmount()).isEqualTo(22.86);
		  assertThat(respPojo.getTotalAmount()).isEqualTo(10022.86);
		}
		
		@Test
		//monthly calculation
		void testCompoundInterestCal4() throws Exception {
			//entering user data 

			reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
					new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(500)), 
					10000.00, 3.0, "monthly", "monthly");
			
			
			//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
			//creating calculation class object
			interest= new CompundInterest();
			//interest calculation
			interest.compoundInterestCal(reqPojo, datePojo,respPojo);

			//System.out.println(respPojo.toString());
			
			 assertThat(respPojo.getPerDay()).isEqualTo(16.8);
			  assertThat(respPojo.getPerMonth()).isEqualTo(503.92);
			  //assertThat(respPojo.getPerYear()).isEqualTo(3600.00);
			  assertThat(respPojo.getInterestTotalAmount()).isEqualTo(6248.66);
			  assertThat(respPojo.getTotalAmount()).isEqualTo(16248.66);
			 

	  
	  
		reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(20)), 
				10000.00, 3.0, "monthly", "monthly");
		
		//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
		//creating calculation class object
		interest= new CompundInterest();
		//interest calculation
		interest.compoundInterestCal(reqPojo, datePojo,respPojo);

	//System.out.println(respPojo.toString());
	
		  assertThat(respPojo.getPerDay()).isEqualTo(11.83);
		  assertThat(respPojo.getPerMonth()).isEqualTo(354.8);
		  //assertThat(respPojo.getPerYear()).isEqualTo(3600.00);
		  assertThat(respPojo.getInterestTotalAmount()).isEqualTo(236.6);
		  assertThat(respPojo.getTotalAmount()).isEqualTo(10236.6);
		  
		  reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
					new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(30)), 
					10000.00, 3.0, "monthly", "monthly");
			
			
			//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
			//creating calculation class object
			interest= new CompundInterest();
			//interest calculation
			interest.compoundInterestCal(reqPojo, datePojo,respPojo);

			//System.out.println(respPojo.toString());
			
			 assertThat(respPojo.getPerDay()).isEqualTo(10.0);
			  assertThat(respPojo.getPerMonth()).isEqualTo(300.0);
			  //assertThat(respPojo.getPerYear()).isEqualTo(3600.00);
			  assertThat(respPojo.getInterestTotalAmount()).isEqualTo(300.00);
			  assertThat(respPojo.getTotalAmount()).isEqualTo(10300.0);
			 
		 
		 }
		
		@Test
		//monthly calculation
		void testCompoundInterestCal5() throws Exception {
			//entering user data 

			reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
					new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(500)), 
					10000.00, null, "monthly", "monthly");
			
			
			
			//Dates calculations
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
			assertThrows(NullPointerException.class, ()->interest.compoundInterestCal(reqPojo, datePojo,respPojo));

	  
		reqPojo= new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(20)), 
				null, 3.0, "monthly", "monthly");

		
		
		//Dates calculations
				dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
		assertThrows(NullPointerException.class, ()->interest.compoundInterestCal(reqPojo, datePojo,respPojo));
		 
		 }
		

}
