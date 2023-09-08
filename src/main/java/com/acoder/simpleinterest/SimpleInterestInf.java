package com.acoder.simpleinterest;

import com.acoder.allpojoclass.DatePojo;
import com.acoder.allpojoclass.SimpleInterestReqPojo;
import com.acoder.allpojoclass.SimpleInterestRespPojo;

public interface SimpleInterestInf {

	public void simpleInterestCalculation
	     (SimpleInterestReqPojo reqPojo, DatePojo datePojo, SimpleInterestRespPojo respPojo);
	

}
