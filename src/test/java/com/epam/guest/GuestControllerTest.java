package com.epam.guest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.epam.guest.dto.GuestDTO;
import com.epam.guest.response.SaveGuestResponse;
import com.epam.guest.response.UpdateGuestResponse;
import com.epam.guest.service.GuestService;

@SpringBootTest
@AutoConfigureMockMvc
public class GuestControllerTest extends AbstractBaseTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	private GuestService guestService;

	@WithMockUser(username = "username", password = "password")
	@Test
	public void saveGuestDetails() throws Exception {
		GuestDTO guest = getGuestDTODetails();
		SaveGuestResponse saveGuestResponse = new SaveGuestResponse();
		saveGuestResponse.setMessage("Guest Details Saved");
		Mockito.when(guestService.saveGuest(guest)).thenReturn(saveGuestResponse);
		mockMvc.perform(post("/guests/api/v1").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(guest))).andExpect(status().isCreated());
	}

	@WithMockUser(username = "username", password = "password")
	@Test
	public void getGuestById() throws Exception {
		GuestDTO guest = getGuestDTODetails();
		Mockito.when(guestService.getGuestById(1)).thenReturn(guest);
		mockMvc.perform(get("/guests/api/v1/1")).andExpect(status().isOk());
	}

	@WithMockUser(username = "username", password = "password")
	@Test
	public void updateGuest() throws Exception {
		GuestDTO guestDTO = getGuestDTODetails();
		long id = 1L;
		UpdateGuestResponse response = new UpdateGuestResponse();
		response.setMessage("Guest details updated successfully");
		Mockito.when(guestService.updateGuest(guestDTO, id)).thenReturn(response);
		mockMvc.perform(put("/guests/api/v1/guestDetails").param("id", String.valueOf(id))
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsBytes(guestDTO)))
				.andExpect(status().isAccepted());
	}

}
