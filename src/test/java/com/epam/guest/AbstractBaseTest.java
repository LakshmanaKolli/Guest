package com.epam.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epam.guest.domain.Guest;
import com.epam.guest.dto.GuestDTO;
import com.epam.guest.mapper.GuestMapper;

public class AbstractBaseTest {

	public GuestDTO getGuestDTODetails() {
		GuestDTO guest = new GuestDTO();
		guest.setName("laxman");
		guest.setPhoneNumber("9705307564");
		return guest;
	}
	
	public Guest getGuestDetails() {
		Guest guest = new Guest();
		guest.setName("laxman");
		guest.setPhoneNumber("9705307564");
		return guest;
	}
}
