package com.acoder.restservice;

import com.acoder.allpojoclass.CompoundReqPojo;
import com.acoder.allpojoclass.CompoundResPojo;
import com.acoder.allpojoclass.SimpleInterestReqPojo;
import com.acoder.allpojoclass.SimpleInterestRespPojo;

public interface RestServiceInf {

	 public SimpleInterestRespPojo simpleInterest( SimpleInterestReqPojo reqPojo )throws Exception;
	 
	 public CompoundResPojo compoundInterest( CompoundReqPojo reqPojo)throws Exception;
}
