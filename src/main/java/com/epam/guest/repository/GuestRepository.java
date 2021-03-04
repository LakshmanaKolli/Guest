package com.epam.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.epam.guest.domain.Guest;

public interface GuestRepository extends ReactiveCrudRepository<Guest, Long>{

}
