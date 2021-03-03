package com.epam.guest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.guest.dto.GuestDTO;
import com.epam.guest.mapper.GuestMapper;
import com.epam.guest.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	GuestMapper mapper;
	
	@Autowired
	GuestRepository guestRepository;
	
	public Object saveGuest(GuestDTO guestDTO) {
		return guestRepository.save(mapper.guestDTOtoGuest(guestDTO));
	}

}
