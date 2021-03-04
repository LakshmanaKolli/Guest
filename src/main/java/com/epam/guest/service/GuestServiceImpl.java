package com.epam.guest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.guest.domain.Guest;
import com.epam.guest.dto.GuestDTO;
import com.epam.guest.mapper.GuestMapper;
import com.epam.guest.repository.GuestRepository;
import com.epam.guest.response.SaveGuestResponse;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	GuestMapper mapper;
	
	@Autowired
	GuestRepository guestRepository;

	public SaveGuestResponse saveGuest(GuestDTO guestDTO) {
		SaveGuestResponse finalResp = new SaveGuestResponse();
		try {
		Guest guestDomain = mapper.guestDTOtoGuest(guestDTO);
		Guest response = guestRepository.save(guestDomain);
		if(response != null) {
			finalResp.setMessage("Guest details saved successfully");
		}
		else {
			finalResp.setMessage("Error saving guest details");
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return finalResp;
	}

}
