package com.aprendendoweb.Course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendoweb.Course.entities.OrderItem;
import com.aprendendoweb.Course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
