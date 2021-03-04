package com.epam.guest.service;

import com.epam.guest.dto.GuestDTO;
import com.epam.guest.response.SaveGuestResponse;

public interface GuestService {

	SaveGuestResponse saveGuest(GuestDTO guest);

}
