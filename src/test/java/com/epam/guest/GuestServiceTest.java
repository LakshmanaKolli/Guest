package com.epam.guest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.guest.domain.Guest;
import com.epam.guest.dto.GuestDTO;
import com.epam.guest.exception.NotFoundException;
import com.epam.guest.repository.GuestRepository;
import com.epam.guest.response.SaveGuestResponse;
import com.epam.guest.service.GuestService;

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
	
	@Test
	public void getGuestById_success() throws Exception{
		Optional<Guest> guest = Optional.of(getGuestDetails());
		Mockito.when(guestRepository.findById(1L)).thenReturn(guest);
		assertEquals("laxman", guestService.getGuestById(1L).getName());
	}
	
	@Test
	public void updateGuest_success() throws Exception{
		long id = 1L;
		Optional<Guest> guest = Optional.of(getGuestDetails());
		Mockito.when(guestRepository.findById(id)).thenReturn(guest);
		assertEquals("Guest details updated successfully", guestService.updateGuest(getGuestDTODetails(), id).getMessage());
	}
	
	@Test
	public void updateGuest_NotFoundException() throws Exception{
		Exception exception = assertThrows(NotFoundException.class, () -> guestService.updateGuest(getGuestDTODetails(),1L));
		assertEquals("Guest details not found for give id : 1", exception.getMessage());
	}

}
