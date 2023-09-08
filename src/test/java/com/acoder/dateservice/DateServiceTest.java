package com.acoder.dateservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.acoder.allpojoclass.DatePojo;
import com.acoder.userdefineexceptions.EndDateShouldBeGreaterThanToStartDate;


class DateServiceTest {

private DateService dateService;

private DatePojo datePojo;

@Mock
//it will provide object
private DateServiceInf inf;

AutoCloseable autoCloseable;
	@BeforeEach
	//this method will run before this class
	void setUp() throws Exception {
		autoCloseable=MockitoAnnotations.openMocks(this);
		 datePojo= new DatePojo();
		dateService = new DateService();
//		System.out.println(datePojo.toString());
	}

	@AfterEach
	//this method run after class
	void tearDown() throws Exception {
	}

	@Test
	void testDateCalculation1() throws Exception {
		//fail("Not yet implemented");
		
	String date1 ="2022-09-12";
	String date2="2023-05-10";
	 when(inf.dateCalculation(date1, date2,datePojo)).thenReturn("Success");
	 
	assertThat(dateService.dateCalculation(date1, date2,datePojo)).isEqualTo("Success");
	//System.out.println(datePojo.toString());
	assertThat(datePojo.getYears()).isNotEqualTo(null);
	assertThat(datePojo.getMonths()).isNotEqualTo(null);
	assertThat(datePojo.getDays()).isNotEqualTo(null);
	}
	
	
	@Test
	void testDateCalculation2() throws Exception {
		//fail("Not yet implemented");
		
	String date1 ="2022-09-12";
	String date2="2023-10-20";
	 when(inf.dateCalculation(date1, date2,datePojo)).thenReturn("Success");
	 
		assertThat(dateService.dateCalculation(date1, date2,datePojo)).isEqualTo("Success");
	assertThat(datePojo.getYears()).isNotEqualTo(null);
	assertThat(datePojo.getMonths()).isNotEqualTo(null);
	assertThat(datePojo.getDays()).isNotEqualTo(null);
	}
	
	
	@Test
	void testDateCalculation3() throws Exception {
		//fail("Not yet implemented");
		
	String date1 ="2022-09-12";
	String date2="2023-05-20";
	
	 when(inf.dateCalculation(date1, date2,datePojo)).thenReturn("Success");
	 
		assertThat(dateService.dateCalculation(date1, date2,datePojo)).isEqualTo("Success");
	assertThat(datePojo.getYears()).isNotEqualTo(null);
	assertThat(datePojo.getMonths()).isNotEqualTo(null);
	assertThat(datePojo.getDays()).isNotEqualTo(null);
	}
	
	@Test
	void testDateCalculation4() throws Exception {
		//fail("Not yet implemented");
		
	String date1 ="2023-09-1";
	String date2="2023-011-2";
	 when(inf.dateCalculation(date1, date2,datePojo)).thenReturn("Success");
	 
		assertThat(dateService.dateCalculation(date1, date2,datePojo)).isEqualTo("Success");

	assertThat(datePojo.getYears()).isNotEqualTo(null);
	assertThat(datePojo.getMonths()).isNotEqualTo(null);
	assertThat(datePojo.getDays()).isNotEqualTo(null);
	}
	  
	@Test
	void testDateCalculation5() throws Exception {
		//fail("Not yet implemented");
		
	String date1 ="2024-09-12";
	String date2="2023-05-20";
	 when(inf.dateCalculation(date1, date2,datePojo)).thenReturn("Start's date should be less than to end's date");
	
	assertThrows(EndDateShouldBeGreaterThanToStartDate.class,
            ()->dateService.dateCalculation(date1, date2,datePojo)).getMessage();	
	
	}
}
