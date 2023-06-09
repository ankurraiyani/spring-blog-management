package com.blogs.app.response;

/**
 * This class extends RunTimeException and is used to provide custom error
 * fields
 * 
 */
public class BlogException extends RuntimeException {

	private static final String EMPTY_STRING = "";
	private static final int ERROR_CODE = 0;

	private String errorMessage;

	private Object data;

	private int errorCode;

	public BlogException(Object data) {

		super(data.toString());

		this.errorMessage = EMPTY_STRING;
		this.data = data;
		this.errorCode = ERROR_CODE;
	}

	public BlogException(String errorMessage) {

		super(errorMessage);

		this.errorMessage = errorMessage;
		this.data = EMPTY_STRING;
		this.errorCode = ERROR_CODE;
	}

	public BlogException(Object data, String errorMessage) {

		super(errorMessage);

		this.errorMessage = errorMessage;
		this.data = data;
		this.errorCode = ERROR_CODE;
	}

	public BlogException(Object data, int errorCode) {

		super(data.toString());

		this.errorMessage = EMPTY_STRING;
		this.data = data;
		this.errorCode = errorCode;
	}

	public BlogException(String errorMessage, int errorCode) {

		super(errorMessage);

		this.errorMessage = errorMessage;
		this.data = EMPTY_STRING;
		this.errorCode = errorCode;
	}

	public BlogException(Object data, String errorMessage, int errorCode) {

		super(errorMessage);

		this.errorMessage = errorMessage;
		this.data = data;
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Object getData() {
		return data;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
