package com.epam.guest.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
public class GuestDTO {
	
	private long id;

	private String name;

	private GuestAddressDTO address;

	private String phoneNumber;
}
