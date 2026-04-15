package com.aprendendoweb.Course.resources.dto;

import java.time.Instant;

import com.aprendendoweb.Course.entities.Payment;

public class PaymentDTO {

	private Long id;
	private Instant moment;
	
	public PaymentDTO(Payment entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
	}
	
	public Long getId() {
		return id;
	}
	
	public Instant getMoment() {
		return moment;
	}
}
