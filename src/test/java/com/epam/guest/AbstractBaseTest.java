package com.epam.guest;

import com.epam.guest.domain.Guest;
import com.epam.guest.domain.GuestAddress;
import com.epam.guest.dto.GuestAddressDTO;
import com.epam.guest.dto.GuestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractBaseTest {

	ObjectMapper mapper = new ObjectMapper();

	public GuestDTO getGuestDTODetails() {
		GuestDTO guest = new GuestDTO();
		guest.setName("laxman");
		guest.setPhoneNumber("9705307564");
		GuestAddressDTO address = new GuestAddressDTO(1, "India", "AP", "VZM", "BRP", "531162");
		guest.setAddress(address);
		return guest;
	}
	
	public Guest getGuestDetails() {
		Guest guest = new Guest();
		guest.setName("laxman");
		guest.setPhoneNumber("9705307564");
		GuestAddress address = new GuestAddress(1, "India", "AP", "VZM", "BRP", "531162");
		guest.setAddress(address);
		return guest;
	}
}
