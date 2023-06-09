package com.blogs.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.blogs.app.response.ApiResponse;

public class ResponseGenerator {

	private static final String EMPTY_STRING = "";
	private static final int ERROR_CODE = 400;
	private static final int SUCCESS_CODE = 0;

	/**
	 * Success methods are used to generate success response for any request with
	 * variant arguments
	 * 
	 * @return
	 */

	public static ResponseEntity<ApiResponse> success() {
		return success(EMPTY_STRING, EMPTY_STRING);
	}

	public static ResponseEntity<ApiResponse> success(Object data) {
		return success(data, EMPTY_STRING);
	}

	public static ResponseEntity<ApiResponse> success(String message) {
		return success(EMPTY_STRING, message);
	}

	/**
	 * This method is used only while call sync from No auth controller to generate
	 * response of list mandatory
	 * 
	 * @param message
	 * @return
	 */
	public static ResponseEntity<List<ApiResponse>> successList(String message) {
		return successList(EMPTY_STRING, message);
	}

	public static ResponseEntity<ApiResponse> success(Object data, String message) {

		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setData(data);
		apiResponse.setMessage(message);
		apiResponse.setErrorCode(SUCCESS_CODE);

		return ResponseEntity.ok(apiResponse);
	}

	public static ResponseEntity<ApiResponse> success(Object data, String message, int code) {

		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setData(data);
		apiResponse.setMessage(message);
		apiResponse.setErrorCode(code);

		return ResponseEntity.ok(apiResponse);
	}

	/**
	 * Generate response as list - mandatory requirement for mobile app while sync
	 * call
	 * 
	 * @param data
	 * @param message
	 * @return
	 */
	public static ResponseEntity<List<ApiResponse>> successList(Object data, String message) {

		List<ApiResponse> apiResponses = new ArrayList<ApiResponse>();

		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setData(data);
		apiResponse.setMessage(message);
		apiResponse.setErrorCode(SUCCESS_CODE);

		apiResponses.add(apiResponse);

		return ResponseEntity.ok(apiResponses);
	}

	public static ResponseEntity<ApiResponse> success(ApiResponse apiResponse) {

		return ResponseEntity.ok(apiResponse);
	}

	/**
	 * Failure methods are used to generate failure response for any request with
	 * variant arguments
	 * 
	 * @return
	 */

	public static ResponseEntity<ApiResponse> failure() {
		return failure(EMPTY_STRING, EMPTY_STRING, ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static ResponseEntity<ApiResponse> failure(Object data) {
		return failure(data, EMPTY_STRING, ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static ResponseEntity<ApiResponse> failure(String message) {
		return failure(EMPTY_STRING, message, ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static ResponseEntity<ApiResponse> failure(Object data, String message) {
		return failure(data, message, ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static ResponseEntity<ApiResponse> failure(Object data, HttpStatus httpStatus) {
		return failure(data, EMPTY_STRING, ERROR_CODE, httpStatus);
	}

	public static ResponseEntity<ApiResponse> failure(String message, HttpStatus httpStatus) {
		return failure(EMPTY_STRING, message, ERROR_CODE, httpStatus);
	}

	public static ResponseEntity<ApiResponse> failure(Object data, String message, HttpStatus httpStatus) {

		return failure(data, message, ERROR_CODE, httpStatus);
	}

	public static ResponseEntity<ApiResponse> failure(Object data, String message, int errorCode,
			HttpStatus httpStatus) {

		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setData(data);
		apiResponse.setMessage(message);
		apiResponse.setErrorCode(errorCode);

		return ResponseEntity.status(httpStatus).body(apiResponse);
	}

}
