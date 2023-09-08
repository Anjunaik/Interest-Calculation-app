package com.acoder.interestrestcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acoder.allpojoclass.CompoundReqPojo;
import com.acoder.allpojoclass.SimpleInterestReqPojo;
import com.acoder.restservice.RestService;

@RestController
public class InterestController 
{
	@Autowired
	private RestService restService;
	
	
	 
	
    /**
     * this method for simple interest calculation 
     * @param reqPojo
     * @return SimpleInterestPojo
     * @throws Exception
     */
    @PostMapping(value="/simple" 
    	    ,produces="application/json"
    	    ,consumes = "application/json"
    		)
	public ResponseEntity<?> simpleInterest(@RequestBody SimpleInterestReqPojo reqPojo ) throws Exception
	{
    	
		return ResponseEntity.ok(restService.simpleInterest(reqPojo));
	}
	
	/**
	 * this method for calculate compound interest
	 * @param reqPojo
	 * @return Compound Response pojo in the format of json
	 * @throws Exception
	 */
	@PostMapping(value="/compound"
			,produces="application/json"
    	    ,consumes = "application/json"
    	    )
	public ResponseEntity<?> compoundInterest(@RequestBody CompoundReqPojo reqPojo) throws Exception
	{
	
		
		return ResponseEntity.ok(restService.compoundInterest(reqPojo));
	}

	
	
}
