package com.aprendendoweb.Course.resources.dto;

import com.aprendendoweb.Course.entities.OrderItem;

public class OrderItemDTO {

	private Integer quantity;
	private Double price;
	private ProductDTO product;

	public OrderItemDTO(OrderItem entity) {
		this.quantity = entity.getQuantity();
		this.price = entity.getPrice();
		this.product = new ProductDTO(entity.getProduct());
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}

	public ProductDTO getProduct() {
		return product;
	}
}
