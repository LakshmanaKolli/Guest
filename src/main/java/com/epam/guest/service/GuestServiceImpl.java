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
import com.epam.guest.response.UpdateGuestResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

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

	@CircuitBreaker(name = "GuestMS",fallbackMethod = "getGuestByIdFallback")
	@Override
	public GuestDTO getGuestById(long guestId) throws NotFoundException {
		Optional<Guest> guest = guestRepository.findById(guestId);
		if(guest.isEmpty()) {
			throw new NotFoundException(String.format("Guest details not found for give id : %s", guestId));
		}
		return mapper.guestToGuestDTO(guest.get());
	}
	
	public GuestDTO getGuestByIdFallback(long guestId, Throwable tr) {
		System.out.println("******fallback*******");
		return new GuestDTO();
	}

	@Override
	public UpdateGuestResponse updateGuest(GuestDTO guestDTO, long id) throws NotFoundException, GuestException {
		Optional<Guest> response = guestRepository.findById(id);
		if(response.isEmpty()) {
			throw new NotFoundException(String.format("Guest details not found for give id : %s", id));
		}
		Guest guest = response.get();
		guest.setName(guestDTO.getName());
		guest.setPhoneNumber(guestDTO.getPhoneNumber());
		guest.getAddress().setArea(guestDTO.getAddress().getArea());
		guest.getAddress().setCity(guestDTO.getAddress().getCity());
		guest.getAddress().setCountry(guestDTO.getAddress().getCountry());
		UpdateGuestResponse userResponse = new UpdateGuestResponse();
		try {
			guestRepository.save(guest);
			userResponse.setMessage("Guest details updated successfully");
		}
		catch (Exception e) {
			throw new GuestException(e.getMessage());
		}
		return userResponse;
	}

}
