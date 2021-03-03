package com.epam.guest.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class GuestAddressDTO {
	
	private long id;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String area;
	
	private String pincode;
}
