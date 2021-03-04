package com.epam.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.guest.domain.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{

}
