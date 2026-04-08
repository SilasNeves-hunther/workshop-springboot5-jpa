package com.aprendendoweb.Course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendoweb.Course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
