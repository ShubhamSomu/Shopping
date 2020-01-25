package com.assignment.shopping.cms.ExceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> allExceptionHandler(Exception ex, WebRequest request, HttpStatus status) {
		MessageResponse exceptionResponse = MessageResponse.builder().message(ex.getCause().toString())
				.description(ex.getMessage()).exceptionTimeStamp(LocalDateTime.now()).build();
		return ResponseEntity.status(status).body(exceptionResponse);
	}

	@ExceptionHandler(RequiredVariableNotFoundException.class)
	public ResponseEntity<?> requiredVariableNotFound(Exception ex, WebRequest request) {
		MessageResponse exceptionResponse = MessageResponse.builder().message("Following attributes cannot be null")
				.description(ex.getMessage()).build();
		return ResponseEntity.badRequest().body(exceptionResponse);
	}

	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<?> internalServerError(Exception ex, WebRequest request, HttpStatus status) {
		return null;

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFound(Exception ex) {
		MessageResponse exceptionResponse = MessageResponse.builder().message(ex.getMessage() + " not found.")
				.description("For given paramater " + ex.getMessage() + " does not exists.")
				.exceptionTimeStamp(LocalDateTime.now()).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
}
