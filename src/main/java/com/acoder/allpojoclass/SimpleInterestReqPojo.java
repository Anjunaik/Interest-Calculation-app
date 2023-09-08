package com.acoder.allpojoclass;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleInterestReqPojo {

	private Date startDate;
	
	private Date endsDate;
	
	private Double principal;
	
	
	private Double interestRate;
	
	private  String ratetype;
	
	
}
