package com.blogs.app.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blogs.app.response.ApiResponse;
import com.blogs.app.response.BlogException;
import com.blogs.app.response.ValidationErrorResponse;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class ExceptionHandlerService {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        ValidationErrorResponse error = new ValidationErrorResponse();

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.getViolations().add(
                    error.new Violation( fieldError.getField(), fieldError.getDefaultMessage())
                );
        }

        return ResponseGenerator.failure(error, "Bad Request", HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(BlogException.class)
	ResponseEntity<ApiResponse> onBlogException(BlogException ex) {
		
		log.error("Caught BlogException :: ", ex);
		
		return ResponseGenerator.failure(ex.getErrorMessage());
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<ApiResponse> onException(Exception e) {
		
		log.error("Faced runtime exception :: ", e);
		
		return ResponseGenerator.failure("There is some techincal problem. Please try again later.");
	}
}
