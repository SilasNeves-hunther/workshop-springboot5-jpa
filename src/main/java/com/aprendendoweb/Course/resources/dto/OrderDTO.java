package com.aprendendoweb.Course.resources.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.aprendendoweb.Course.entities.Order;

public class OrderDTO {
	private Long id;
	private Instant moment;
	private String orderStatus;
	private UserDTO client;
	private List<OrderItemDTO> items;
	private PaymentDTO payment;
	private Double  total;

	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.orderStatus = entity.getOrderStatus().toString();
		this.client = new UserDTO(entity.getClient());
		this.items = entity.getItems().stream().map(OrderItemDTO::new).collect(Collectors.toList());
		
		if(entity.getPayment() != null) {
			this.payment = new PaymentDTO(entity.getPayment());
		}
		this.total = entity.getTotal();
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public UserDTO getClient() {
		return client;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}
	
	public PaymentDTO getPayment() {
		return payment;
	}
	
	public Double getTotal() {
		return total;
	}
}
