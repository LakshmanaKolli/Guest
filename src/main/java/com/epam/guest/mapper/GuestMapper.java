package com.epam.guest.mapper;

import org.mapstruct.Mapper;

import com.epam.guest.domain.Guest;
import com.epam.guest.dto.GuestDTO;

@Mapper(componentModel = "spring", uses = {GuestAddressMapper.class})
public interface GuestMapper {
	Guest guestDTOtoGuest(GuestDTO dto);
	GuestDTO guestToGuestDTO(Guest domain);
}
