package com.epam.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.epam.guest.dto.GuestDTO;
import com.epam.guest.exception.GuestException;
import com.epam.guest.exception.NotFoundException;
import com.epam.guest.response.SaveGuestResponse;
import com.epam.guest.response.UpdateGuestResponse;
import com.epam.guest.service.GuestService;

@RestController
public class GuestControllerImpl implements GuestController{
	
	@Autowired
	private GuestService service;

	@Override
	public ResponseEntity<SaveGuestResponse> saveGuest(GuestDTO guestDTO) throws GuestException {
		return new ResponseEntity<>(service.saveGuest(guestDTO),HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<GuestDTO> getGuestById(long guestId) throws NotFoundException {
		return new ResponseEntity<>(service.getGuestById(guestId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UpdateGuestResponse> updateGuest(GuestDTO guestDTO, long id) throws NotFoundException, GuestException {
		return new ResponseEntity<>(service.updateGuest(guestDTO, id), HttpStatus.ACCEPTED);
	}

}
