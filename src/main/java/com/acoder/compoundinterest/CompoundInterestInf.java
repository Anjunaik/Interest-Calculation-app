package com.acoder.compoundinterest;

import com.acoder.allpojoclass.CompoundReqPojo;
import com.acoder.allpojoclass.CompoundResPojo;
import com.acoder.allpojoclass.DatePojo;

//compound interest interface
public interface CompoundInterestInf {
	
	public void compoundInterestCal(CompoundReqPojo reqPojo, DatePojo datePojo, CompoundResPojo resPojo);

}
