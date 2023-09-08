package com.acoder.simpleinterest;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import com.acoder.allpojoclass.DatePojo;
import com.acoder.allpojoclass.SimpleInterestReqPojo;
import com.acoder.allpojoclass.SimpleInterestRespPojo;

@Service
public class SimpleInterest  implements SimpleInterestInf{
	
	
	
	@Override
public void simpleInterestCalculation(
		SimpleInterestReqPojo reqPojo,
		DatePojo datePojo,
		SimpleInterestRespPojo respPojo
		)
{
	/*
	 * if(reqPojo.getStartDate()!=null&& reqPojo.getEndsDate()!=null&&
	 * reqPojo.getInterestRate()!=null&& reqPojo.getPrincipal()!=null&&
	 * reqPojo.getRatetype()!=null
	 * 
	 * ) {
	 */
		respPojo.setDays(datePojo.getDays());
		respPojo.setMonths(datePojo.getMonths());
		respPojo.setYears(datePojo.getYears());
		 DecimalFormat decimalFormat = new DecimalFormat("0.##");
		 
		if(reqPojo.getRatetype().equals("yearly"))
		{
			Double oneYear=reqPojo.getPrincipal()*reqPojo.getInterestRate()/100;
			
			Double total=0.0;
	        respPojo.setPerYear(( Double.parseDouble(decimalFormat.format(oneYear))));
	        respPojo.setPerMonth(( Double.parseDouble(decimalFormat.format(respPojo.getPerYear()/12))));
	        respPojo.setPerDay(( Double.parseDouble(decimalFormat.format(respPojo.getPerMonth()/30))));
	
	        if(datePojo.getYears()!=null&&datePojo.getYears()!=0)
	        	 total+=respPojo.getPerYear()*(datePojo.getYears());
	        	 
	        	 if(datePojo.getMonths()!=null&&datePojo.getMonths()!=0)
	        		 total+=respPojo.getPerMonth()*datePojo.getMonths();
	        	
	        		 
	        		 if(datePojo.getDays()!=null&&datePojo.getDays()!=0)
	        			 total+=respPojo.getPerDay()*datePojo.getDays();	       
	        		 
	        	
	        		 respPojo.setInterestTotalAmount(( Double.parseDouble(decimalFormat.format(total))));
	        		 
	        		 respPojo.setTotalAmount(( Double.parseDouble(decimalFormat.format(reqPojo.getPrincipal()+respPojo.getInterestTotalAmount()))));
			
			
		}
		
		else if(reqPojo.getRatetype().equals("monthly"))
		{
			Double total=0.0;
			Double oneMonth=reqPojo.getPrincipal()*reqPojo.getInterestRate()/100;
			 respPojo.setPerYear(( Double.parseDouble(decimalFormat.format(oneMonth*12))));
		        respPojo.setPerMonth(( Double.parseDouble(decimalFormat.format(oneMonth))));
		        respPojo.setPerDay(( Double.parseDouble(decimalFormat.format(respPojo.getPerMonth()/30))));
		
			
			if(datePojo.getYears()!=null&&datePojo.getYears()!=0)
	        	 total+=respPojo.getPerMonth()*(datePojo.getYears()*12);
	        	 
	        	 if(datePojo.getMonths()!=null&&datePojo.getMonths()!=0)
	        		 total+=respPojo.getPerMonth()*datePojo.getMonths();
	        	
	        		 
	        		 if(datePojo.getDays()!=null&&datePojo.getDays()!=0)
	        			 total+=respPojo.getPerDay()*datePojo.getDays();	       
	        		 
	        		 
	        		 respPojo.setInterestTotalAmount(( Double.parseDouble(decimalFormat.format(total))));
	        		 
	        		 respPojo.setTotalAmount(( Double.parseDouble(decimalFormat.format(reqPojo.getPrincipal()+respPojo.getInterestTotalAmount()))));
			
		}
		
		/*}
		else
		{
			throw new NullPointerException();
		}*/
	
}



}
