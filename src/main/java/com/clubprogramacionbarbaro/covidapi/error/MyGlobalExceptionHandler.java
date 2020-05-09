package com.clubprogramacionbarbaro.covidapi.error;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UnauthorizedException.class)
	public void handleNotFoundException(HttpServletResponse response) {
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public void handleConstraintViolationException(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public void handleSQLIntegrityConstraintViolationException(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	}
}
