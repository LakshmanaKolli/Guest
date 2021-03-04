package com.epam.guest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	private String message;
 
    private String statuCode;
    
    public ErrorResponse(String message) {
    	this.message = message;
    }
}
