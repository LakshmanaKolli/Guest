package com.epam.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.guest.dto.GuestDTO;
import com.epam.guest.service.GuestService;

@RestController
@RequestMapping("/guest")
public class GuestControllerImpl implements GuestController{
	
	@Autowired
	private GuestService service;

	@Override
	public ResponseEntity<Object> saveGuest(GuestDTO guestDTO) {
		return new ResponseEntity<>(service.saveGuest(guestDTO),HttpStatus.CREATED);
	}

}
