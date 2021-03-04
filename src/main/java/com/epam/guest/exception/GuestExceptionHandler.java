package com.epam.guest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GuestExceptionHandler {
	
	@ExceptionHandler(GuestException.class)
    public final ResponseEntity<Object> guestExceptionError(GuestException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(),500);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> guestExceptionError(NotFoundException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(),404);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

}
