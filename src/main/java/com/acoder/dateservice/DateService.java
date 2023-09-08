package com.acoder.dateservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.acoder.allpojoclass.DatePojo;
import com.acoder.userdefineexceptions.EndDateShouldBeGreaterThanToStartDate;

@Service
public class DateService  implements DateServiceInf
{
	
	
	

	@Override
	
	//this method is used for calculate years, months and days between two dates
	public String dateCalculation(String start, String end,DatePojo date) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		
		Date date4=sdf.parse(start);
		Date date5=sdf.parse(end);
		
		if(date4.before(date5))
		{
		//start date
		String date1[]=start.split("-");
		
		//end date
		String date2[]=end.split("-");
		int year1,year2,month1,month2,day1,day2;
		year1=Integer.parseInt(date1[0]);
		month1=Integer.parseInt(date1[1]);
		day1=Integer.parseInt(date1[2]);
		year2=Integer.parseInt(date2[0]);
		month2=Integer.parseInt(date2[1]);
		day2=Integer.parseInt(date2[2]);
		
		
			if (year2 >= year1) {
				if (day2 >= day1) {
					date.setDays(day2 - day1);
				} else {
					month2--;
					day2 += 30;
					date.setDays(day2 - day1);
					
				}
				if (month2 >= month1) {
					date.setMonths(month2 - month1);
				} else {
					year2--;
					month2 += 12;
					date.setMonths(month2 - month1);
				}
				date.setYears(year2 - year1);
			}
			
		
			return "Success";
			}
	else
	{
	 throw new EndDateShouldBeGreaterThanToStartDate("Start's date should be less than to end's date");
	}
	
	
}
}
