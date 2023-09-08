package com.acoder.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acoder.allpojoclass.CompoundReqPojo;
import com.acoder.allpojoclass.CompoundResPojo;
import com.acoder.allpojoclass.DatePojo;
import com.acoder.allpojoclass.SimpleInterestReqPojo;
import com.acoder.allpojoclass.SimpleInterestRespPojo;
import com.acoder.compoundinterest.CompundInterest;
import com.acoder.dateservice.DateService;
import com.acoder.simpleinterest.SimpleInterest;

@Service
public class RestService  implements RestServiceInf{
	
	@Autowired
    private SimpleInterest simpleInterest;
	
	 @Autowired 
	 private CompundInterest compundInterest;
	
	 @Autowired
	private DateService dateService;
	 
	 
	
	 public SimpleInterestRespPojo simpleInterest( SimpleInterestReqPojo reqPojo ) throws Exception
		{
	    	
	    	//date calculation
	    	DatePojo datePojo = new DatePojo();
	    	SimpleInterestRespPojo respPojo = new SimpleInterestRespPojo();
	    	
			dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
	    	
	    	
			//simple interest calculation
	    	simpleInterest.simpleInterestCalculation(reqPojo, datePojo,respPojo);
	    	
			return respPojo;
		}
	 
	 public CompoundResPojo compoundInterest( CompoundReqPojo reqPojo) throws Exception
		{
			DatePojo datePojo = new DatePojo();
			CompoundResPojo resPojo= new CompoundResPojo();
//	    	DateService dateService= new DateService(datePojo);
	    	
			//date calculation 
	    	dateService.dateCalculation(""+reqPojo.getStartDate(), ""+reqPojo.getEndsDate(),datePojo);
	    	
			compundInterest.compoundInterestCal(reqPojo, datePojo,resPojo);
			return resPojo;
		}

}
