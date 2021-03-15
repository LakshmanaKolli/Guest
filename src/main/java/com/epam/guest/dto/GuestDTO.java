package com.epam.guest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestDTO {
	
	private long id;

	private String name;

	private GuestAddressDTO address;

	private String phoneNumber;
}
