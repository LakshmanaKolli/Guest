package com.epam.guest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.guest.domain.Guest;
import com.epam.guest.dto.GuestDTO;

@RequestMapping("/default")
public interface GuestController {
	
	@PostMapping("/api/save")
	public ResponseEntity<Object> saveGuest(@RequestBody GuestDTO guestDTO);
}
