package com.aprendendoweb.Course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendoweb.Course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
