package com.epam.guest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.guest.domain.Guest;
import com.epam.guest.dto.GuestDTO;
import com.epam.guest.response.SaveGuestResponse;
import com.epam.guest.service.GuestService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class GuestControllerTest extends AbstractBaseTest{
	@Autowired
	MockMvc mockMvc;

	@MockBean
	private GuestService guestService;

	@Test
	public void saveGuestDetails() throws Exception {
		GuestDTO guest = getGuestDTODetails();
		SaveGuestResponse saveGuestResponse = new SaveGuestResponse();
		saveGuestResponse.setMessage("Guest Details Saved");
		Mockito.when(guestService.saveGuest(guest)).thenReturn(saveGuestResponse);
		ObjectMapper mapper = new ObjectMapper();
		mockMvc.perform(post("/guests/api/v1").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(guest))).andExpect(status().isCreated());
	}
	
	@Test
	public void getGuestById() throws Exception{
		GuestDTO guest = getGuestDTODetails();
		Mockito.when(guestService.getGuestById(1)).thenReturn(guest);
		mockMvc.perform(get("/guests/api/v1/1")).andExpect(status().isOk());
	}
}
