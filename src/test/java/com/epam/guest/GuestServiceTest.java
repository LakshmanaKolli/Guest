package com.epam.guest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.epam.guest.domain.Guest;
import com.epam.guest.dto.GuestDTO;
import com.epam.guest.repository.GuestRepository;
import com.epam.guest.response.SaveGuestResponse;
import com.epam.guest.service.GuestService;
import com.epam.guest.service.GuestServiceImpl;

@SpringBootTest
public class GuestServiceTest extends AbstractBaseTest{
	
	@MockBean
	private GuestRepository guestRepository;
	
	@Autowired
	private GuestService guestService;
	
	@Test
	public void saveGuestDetails_success() throws Exception{
		Guest guest = getGuestDetails();
		GuestDTO guestDTO = getGuestDTODetails();
		Mockito.when(guestRepository.save(guest)).thenReturn(guest);
		SaveGuestResponse guestResponse = guestService.saveGuest(guestDTO);
		assertEquals("Guest details saved successfully",guestResponse.getMessage());
	}
	
//	@Test
//	public void saveGuestDetails_unsuccessfull() throws Exception{
//		Guest guest = getGuestDetails();
//		GuestDTO guestDTO = getGuestDTODetails();
//		Mockito.when(guestRepository.save(guest)).then()
//		SaveGuestResponse guestResponse = guestService.saveGuest(guestDTO);
//		assertEquals("Guest details saved successfully",guestResponse.getMessage());
//	}
	

}
