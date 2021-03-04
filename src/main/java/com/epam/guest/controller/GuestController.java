package com.epam.guest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.guest.dto.GuestDTO;
import com.epam.guest.exception.GuestException;
import com.epam.guest.response.SaveGuestResponse;

@RequestMapping("/guests/api/v1")
public interface GuestController {
	
	@PostMapping
	public ResponseEntity<SaveGuestResponse> saveGuest(@RequestBody GuestDTO guestDTO) throws GuestException;

	
}
