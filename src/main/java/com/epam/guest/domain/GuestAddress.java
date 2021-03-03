package com.epam.guest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;

@Data
@Entity(name = "guestaddress")
public class GuestAddress {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String area;
	
	private String pincode;
	
}
