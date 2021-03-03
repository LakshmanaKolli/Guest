package com.epam.guest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.guest.domain.Guest;
import com.epam.guest.response.SaveGuestResponse;
import com.epam.guest.service.GuestService;
import com.fasterxml.jackson.databind.ObjectMapper;

import springfox.documentation.spring.web.json.Json;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class GuestControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	private GuestService guestService;

	public Guest getGuestDetails() {
		Guest guest = new Guest();
		guest.setName("laxman");
		guest.setPhoneNumber("9705307564");
		return guest;
	}

//	@Test
//	public void saveGuestDetails() throws Exception {
//		Guest guest = getGuestDetails();
//		SaveGuestResponse saveGuestResponse = new SaveGuestResponse();
//		saveGuestResponse.setMessage("Guest Details Saved");
//		Mockito.when(guestService.saveGuest(guest)).thenReturn(saveGuestResponse);
//		ObjectMapper mapper = new ObjectMapper();
//		mockMvc.perform(post("/guest/api/save").contentType(MediaType.APPLICATION_JSON)
//				.content(mapper.writeValueAsString(guest))).andExpect(status().isCreated());
//	}
}
