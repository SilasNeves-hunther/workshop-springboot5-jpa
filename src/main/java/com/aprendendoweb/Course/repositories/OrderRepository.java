package com.aprendendoweb.Course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendoweb.Course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
