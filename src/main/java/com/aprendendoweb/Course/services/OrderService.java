package com.aprendendoweb.Course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprendendoweb.Course.entities.Order;
import com.aprendendoweb.Course.repositories.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Transactional
	public List<Order> findAll() {
		List<Order> orders = repository.findAll();
		orders.forEach(o -> o.getItems().size());
		return orders;
	}

	@Transactional
	public Order findById(Long id) {
		Order order = repository.findById(id).orElseThrow();
		order.getItems().size();
		return order;
	}
}
