package com.web.spring.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.web.spring.dto.ErrorResponseDto;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(LoanAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(
			LoanAlreadyExistsException alreadyExistsException,WebRequest request){
		ErrorResponseDto dto = new ErrorResponseDto(
				request.getDescription(true),
				HttpStatus.BAD_REQUEST,
				alreadyExistsException.getMessage(),
					LocalDateTime.now());
		return new ResponseEntity<ErrorResponseDto>(dto,HttpStatus.BAD_REQUEST);		
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,HttpHeaders headers, 
			HttpStatus status, WebRequest request){
			Map<String,String> validationErrors = new HashMap<>();
			List<ObjectError> validationListError = ex.getBindingResult().getAllErrors();
			validationListError.forEach((error)->{
				
				String firldName = ((FieldError)error).getField();
				String validationMsg = error.getDefaultMessage();
				validationErrors.put(firldName, validationMsg);
			});
		return new ResponseEntity<Object>(validationErrors,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				description = "account deleted"
				),
		@ApiResponse(
				responseCode = "500",
				description = "internal server error"
				)
}
		)
	public ResponseEntity<ErrorResponseDto> handleException(
			LoanAlreadyExistsException alreadyExistsException,WebRequest request){
		ErrorResponseDto dto = new ErrorResponseDto(
				request.getDescription(true),
				HttpStatus.INTERNAL_SERVER_ERROR,
				alreadyExistsException.getMessage(),
					LocalDateTime.now());
		return new ResponseEntity<ErrorResponseDto>(dto,HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerNotFoundException(
			ResourceNotFoundException alreadyExistsException,WebRequest request){
		ErrorResponseDto dto = new ErrorResponseDto(
				request.getDescription(true),
				HttpStatus.NOT_FOUND,
				alreadyExistsException.getMessage(),
					LocalDateTime.now());
		return new ResponseEntity<ErrorResponseDto>(dto,HttpStatus.NOT_FOUND);
		
	}


}
