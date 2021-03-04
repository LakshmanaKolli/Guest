package com.epam.guest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.guest.domain.Guest;
import com.epam.guest.dto.GuestDTO;
import com.epam.guest.exception.GuestException;
import com.epam.guest.mapper.GuestMapper;
import com.epam.guest.repository.GuestRepository;
import com.epam.guest.response.SaveGuestResponse;

import net.bytebuddy.implementation.bytecode.Throw;
import reactor.core.publisher.Mono;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	GuestMapper mapper;

	@Autowired
	GuestRepository guestRepository;

	public Mono<SaveGuestResponse> saveGuest(GuestDTO guestDTO) {
		SaveGuestResponse finalResp = new SaveGuestResponse();
		Guest guestDomain = mapper.guestDTOtoGuest(guestDTO);
		guestRepository.save(guestDomain).switchIfEmpty(Mono.error(new GuestException("Error saving guest details")))
				.block();
		finalResp.setMessage("Guest details saved successfully");
		return Mono.just(finalResp);
	}

}
