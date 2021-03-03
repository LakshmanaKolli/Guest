package com.epam.guest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
@Entity(name = "guest")
public class Guest {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OneToOne
	@JoinColumn(name = "id")
	private GuestAddress address;
	
	private String phoneNumber;
}
