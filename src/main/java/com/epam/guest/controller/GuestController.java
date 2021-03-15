package com.epam.guest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.guest.dto.GuestDTO;
import com.epam.guest.exception.GuestException;
import com.epam.guest.exception.NotFoundException;
import com.epam.guest.response.SaveGuestResponse;
import com.epam.guest.response.UpdateGuestResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@ApiResponse(description = "Guest service")
@RequestMapping("/guests/api/v1")
@SecurityRequirement(name = "bearerAuth")
public interface GuestController {

	@Operation(summary = "Saves guest details")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Saved guest details", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = SaveGuestResponse.class)) }) })
	@PostMapping
	public ResponseEntity<SaveGuestResponse> saveGuest(@RequestBody GuestDTO guestDTO) throws GuestException;

	@Operation(summary = "fetches guest details")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "retrieved guest details", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = GuestDTO.class)) }) })
	@GetMapping("/{guestId}")
	public ResponseEntity<GuestDTO> getGuestById(@PathVariable long guestId) throws NotFoundException;

	@Operation(summary = "Updates guest details")
	@ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Updated guest details", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UpdateGuestResponse.class)) }) })
	@PutMapping("/guestDetails")
	public ResponseEntity<UpdateGuestResponse> updateGuest(@RequestBody GuestDTO guestDTO, @RequestParam long id)
			throws NotFoundException, GuestException;
}
