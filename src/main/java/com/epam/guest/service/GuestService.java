package com.epam.guest.service;

import com.epam.guest.dto.GuestDTO;
import com.epam.guest.response.SaveGuestResponse;

import reactor.core.publisher.Mono;

public interface GuestService {

	Mono<SaveGuestResponse> saveGuest(GuestDTO guest);

}
