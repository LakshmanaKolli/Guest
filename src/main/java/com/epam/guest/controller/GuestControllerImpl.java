package com.epam.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.guest.dto.GuestDTO;
import com.epam.guest.response.SaveGuestResponse;
import com.epam.guest.service.GuestService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/guest")
public class GuestControllerImpl implements GuestController{
	
	@Autowired
	private GuestService service;

	@Override
	public ResponseEntity<Mono<SaveGuestResponse>> saveGuest(GuestDTO guestDTO) {
		return new ResponseEntity<>(service.saveGuest(guestDTO),HttpStatus.CREATED);
	}

}
