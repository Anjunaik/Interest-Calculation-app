package com.acoder.restservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.acoder.allpojoclass.CompoundReqPojo;
import com.acoder.allpojoclass.CompoundResPojo;
import com.acoder.allpojoclass.SimpleInterestReqPojo;
import com.acoder.allpojoclass.SimpleInterestRespPojo;

class RestServiceTest {

	@Mock
	private RestServiceInf inf;
	
	
	
	
	
	AutoCloseable autoCloseable;
	
	SimpleInterestReqPojo interestReqPojo;
	
	CompoundReqPojo compoundReqPojo;
	

	
	private SimpleInterestRespPojo interestRespPojo;
	
	CompoundResPojo compoundResPojo;
	 
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		autoCloseable=MockitoAnnotations.openMocks(this);
		
		interestReqPojo=new SimpleInterestReqPojo
				(new Date(System.currentTimeMillis()),
						new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(256)), 
						10000.00, 
					    3.0, 
						"yearly");
		
      compoundReqPojo = new CompoundReqPojo(new Date(System.currentTimeMillis()), 
				new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(400)), 
				10000.00, 3.0, "yearly", "annually");
		
		 compoundResPojo= new CompoundResPojo();
		 interestRespPojo= new  SimpleInterestRespPojo();
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void test() throws Exception {
		
		
    when(inf.simpleInterest(interestReqPojo)).thenReturn(interestRespPojo);
    
    assertThat(inf.simpleInterest(interestReqPojo)).isEqualTo(interestRespPojo);
	}
	
	

	@Test
	void test2() throws Exception {
		
		
    when(inf.compoundInterest(compoundReqPojo)).thenReturn(compoundResPojo);
    
    assertThat(inf.compoundInterest(compoundReqPojo)).isEqualTo(compoundResPojo);
	}

}
