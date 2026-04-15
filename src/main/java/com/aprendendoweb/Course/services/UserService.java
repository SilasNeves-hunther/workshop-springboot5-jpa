package com.aprendendoweb.Course.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aprendendoweb.Course.entities.User;
import com.aprendendoweb.Course.repositories.UserRepository;
import com.aprendendoweb.Course.resources.dto.UserDTO;
import com.aprendendoweb.Course.resources.dto.UserInsertDTO;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public List<UserDTO> findAll() {
		return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
	}

	@Transactional
	public UserDTO findById(Long id) {
		User user = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		return new UserDTO(user);
	}

	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setPassword(dto.getPassword());
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional
	public void delete(Long id) {
		try {
			if (!repository.existsById(id)) {
				throw new RuntimeException("Usuário não encontrado");
			}
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Não é possivel excluir o usuário porque está associado a outras entidades");
		}
	}
}
