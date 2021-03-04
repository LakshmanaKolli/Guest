package com.epam.guest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.guest.dto.GuestDTO;
import com.epam.guest.response.SaveGuestResponse;

import reactor.core.publisher.Mono;

@RequestMapping("/default")
public interface GuestController {
	
	@PostMapping("/api/save")
	public ResponseEntity<Mono<SaveGuestResponse>> saveGuest(@RequestBody GuestDTO guestDTO);
}
