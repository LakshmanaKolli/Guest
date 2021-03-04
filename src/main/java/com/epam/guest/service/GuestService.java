package com.epam.guest.service;

import com.epam.guest.dto.GuestDTO;
import com.epam.guest.exception.GuestException;
import com.epam.guest.exception.NotFoundException;
import com.epam.guest.response.SaveGuestResponse;
import com.epam.guest.response.UpdateGuestResponse;

public interface GuestService {

	SaveGuestResponse saveGuest(GuestDTO guest) throws GuestException;

	GuestDTO getGuestById(long guestId) throws NotFoundException;

	UpdateGuestResponse updateGuest(GuestDTO guestDTO, long id) throws NotFoundException, GuestException;

}
