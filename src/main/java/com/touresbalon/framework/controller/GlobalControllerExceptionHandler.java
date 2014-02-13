package com.touresbalon.framework.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
 * http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/mvc.html#mvc-exceptionhandlers
 *  
 * @author efren
 *
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	// Convert a predefined exception to an HTTP Status code
	@ResponseStatus(value=HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
	@ExceptionHandler(DataIntegrityViolationException.class)
	public void conflict() {
		// Nothing to do
	}


	//@ExceptionHandler(value = Exception.class /*{  IllegalArgumentException.class, IllegalStateException.class } */)	 
	@ExceptionHandler({SQLException.class,DataAccessException.class})
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = ex.getLocalizedMessage();
		return handleExceptionInternal(ex, bodyOfResponse, 
				new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	//http://mariuszprzydatek.com/2013/08/22/spring-rest-api-hardening-exceptions-handling/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>(ex.getAllErrors().size());
		List<FieldError> fieldErrors = ex.getFieldErrors();
		StringBuilder sb;

		for (FieldError fieldError : fieldErrors) {
			sb = new StringBuilder();
			sb.append("Field: ").append(fieldError.getField()).append(", ");
			sb.append("Value: ").append(fieldError.getRejectedValue()).append(", ");
			sb.append("Message: ").append(fieldError.getDefaultMessage());
			errors.add(sb.toString());
		}

		List<ObjectError> globalErrors = ex.getGlobalErrors();

		for (ObjectError objectError : globalErrors) {
			sb = new StringBuilder();
			sb.append("Object: ").append(objectError.getObjectName()).append(", ");
			sb.append("Code: ").append(objectError.getCode()).append(", ");
			sb.append("Message: ").append(objectError.getDefaultMessage());
			errors.add(sb.toString());
		}

		DefaultErrorMessage errorMessage = new DefaultErrorMessage("RQ00051", "RQ_BODY_VALIDATION_ERROR", errors);
		return new ResponseEntity(errorMessage, headers, status);

	}
}
