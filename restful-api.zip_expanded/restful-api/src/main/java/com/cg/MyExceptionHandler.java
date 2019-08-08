package com.cg;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
class MyExceptionHandler {

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public String employeeNotFoundHandler(Exception ex) {
		return "some problem in spring boot application";
	}
}