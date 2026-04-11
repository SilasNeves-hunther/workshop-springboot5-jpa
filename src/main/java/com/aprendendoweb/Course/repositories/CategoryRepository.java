package com.aprendendoweb.Course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendoweb.Course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
