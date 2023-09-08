package com.acoder.exception;

import java.text.ParseException;
import java.util.Date;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.acoder.allpojoclass.ExceptionPojo;
import com.acoder.userdefineexceptions.EndDateShouldBeGreaterThanToStartDate;

@ControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(value = EndDateShouldBeGreaterThanToStartDate.class)
	public ResponseEntity<ExceptionPojo> greaterlessThanExcetionHandling()
	{
		ExceptionPojo pojo = new ExceptionPojo();
		
		pojo.setMegs("To date should Greater than From date");
        pojo.setStatusCode(HttpStatus.SC_BAD_REQUEST);
        pojo.setDate(new Date());
		return  new ResponseEntity<ExceptionPojo>(pojo,org.springframework.http.HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(value = {NullPointerException.class,HttpMessageNotReadableException.class})
	public ResponseEntity<?>  nullPointerExceptionHandling()
	{
		
        ExceptionPojo pojo = new ExceptionPojo();		
		pojo.setMegs("Something Wrong Try once Again and Please Enter valid Data..");
        pojo.setStatusCode(HttpStatus.SC_BAD_REQUEST);
        pojo.setDate(new Date());
	return  new ResponseEntity<ExceptionPojo>(pojo,org.springframework.http.HttpStatus.BAD_REQUEST);	
	}
	
	
	@ExceptionHandler(value = ParseException.class)
	public ResponseEntity<ExceptionPojo> paserException()
	{

        ExceptionPojo pojo = new ExceptionPojo();		
		pojo.setMegs("Something Wrong Try once Again and Please Enter valid  Details..");
        pojo.setStatusCode(HttpStatus.SC_BAD_REQUEST);
        pojo.setDate(new Date());
        
        return new ResponseEntity<ExceptionPojo>(pojo,org.springframework.http.HttpStatus.BAD_REQUEST);	
    	
	}
	
	
}
