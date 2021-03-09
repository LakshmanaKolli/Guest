package com.epam.guest.dto;

import lombok.Data;

@Data
public class GuestDTO {
	
	private long id;

	private String name;

	private GuestAddressDTO address;

	private String phoneNumber;
}
