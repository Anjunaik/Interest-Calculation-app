package com.acoder.userdefineexceptions;

public class EndDateShouldBeGreaterThanToStartDate extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EndDateShouldBeGreaterThanToStartDate(String mgs) {
		super(mgs);
	}

}
