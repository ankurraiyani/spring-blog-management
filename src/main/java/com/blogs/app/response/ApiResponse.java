package com.blogs.app.response;

import lombok.Data;

@Data
public class ApiResponse {

	private Object data;

	private String message;
	
	private int errorCode;

}

