package com.hr.exception;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hr.util.ErrorResponse;

@ControllerAdvice
public class AppErrorHandler extends ResponseEntityExceptionHandler {
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		    ErrorResponse errorResponse = new ErrorResponse(LocalDate.now(),"Validation failed");
		    return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
      
	  
      @ExceptionHandler(DuplicateEmployeeException.class)
      public ResponseEntity<ErrorResponse> handleduplicateDataException(DuplicateEmployeeException ex){
	   return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(),HttpStatus.BAD_REQUEST);
      }
      
      
      @ExceptionHandler(EmployeeNotFoundException.class)
	   public ResponseEntity<ErrorResponse> handlEmployeeNotFoundException(EmployeeNotFoundException ex){
		   return new ResponseEntity<ErrorResponse>(ex.getErrorResponse(),HttpStatus.NOT_FOUND);
	   }
}
