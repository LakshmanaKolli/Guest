package com.epam.guest.mapper;

import org.mapstruct.Mapper;

import com.epam.guest.domain.GuestAddress;
import com.epam.guest.dto.GuestAddressDTO;

@Mapper(componentModel = "spring")
public interface GuestAddressMapper {

	GuestAddress toGuestAddress(GuestAddressDTO dto);
	GuestAddressDTO toGuestAddressDTO(GuestAddress domain);
	
}
