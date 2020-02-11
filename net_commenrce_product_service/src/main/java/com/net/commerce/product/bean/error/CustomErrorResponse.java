package com.net.commerce.product.bean.error;

import com.fasterxml.jackson.annotation.JsonFormat;
 
public class CustomErrorResponse extends Exception {
   
	static final  long  serialVersionUID  = 1223;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private String message ;

	
	
	public CustomErrorResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
	
}
