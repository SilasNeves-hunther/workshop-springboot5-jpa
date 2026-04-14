package com.aprendendoweb.Course.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aprendendoweb.Course.entities.Order;
import com.aprendendoweb.Course.repositories.OrderRepository;
import com.aprendendoweb.Course.resources.dto.OrderDTO;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<OrderDTO> findAll(){
        return repository.findAll()
                         .stream()
                         .map(OrderDTO::new)
                         .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return new OrderDTO(order);
    }
}

