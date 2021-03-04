package com.epam.guest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.guest.domain.Guest;
import com.epam.guest.dto.GuestDTO;
import com.epam.guest.exception.GuestException;
import com.epam.guest.exception.NotFoundException;
import com.epam.guest.mapper.GuestMapper;
import com.epam.guest.repository.GuestRepository;
import com.epam.guest.response.SaveGuestResponse;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	GuestMapper mapper;
	
	@Autowired
	GuestRepository guestRepository;

	public SaveGuestResponse saveGuest(GuestDTO guestDTO) throws GuestException {
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
			throw new GuestException(e.getMessage());
		}
		return finalResp;
	}

	@Override
	public GuestDTO getGuestById(long guestId) throws NotFoundException {
		Optional<Guest> guest = guestRepository.findById(guestId);
		if(guest.isEmpty()) {
			throw new NotFoundException(String.format("Guest details not found for give id : %s", guestId));
		}
		return mapper.guestToGuestDTO(guest.get());
	}

}
