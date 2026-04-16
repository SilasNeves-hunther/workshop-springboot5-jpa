package com.aprendendoweb.Course.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.aprendendoweb.Course.entities.User;
import com.aprendendoweb.Course.repositories.UserRepository;
import com.aprendendoweb.Course.resources.dto.UserDTO;
import com.aprendendoweb.Course.resources.dto.UserInsertDTO;
import com.aprendendoweb.Course.services.exceptions.DatabaseException;
import com.aprendendoweb.Course.services.exceptions.ResourceNotFoundException;

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
		User user = repository.findById(id).orElseThrow(() -> new com.aprendendoweb.Course.services.exceptions.ResourceNotFoundException("Usuário não encontrado"));
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

	public void delete(Long id) {
		 try {
		        repository.deleteById(id);
		    } catch (EmptyResultDataAccessException e) {
		        throw new ResourceNotFoundException("Usuário com ID" + id + "não encontrado");
		    } catch (DataIntegrityViolationException e) {
		        throw new DatabaseException("Não é possível excluir o usuário porque está associado a outras entidades");
		    }
	}
		@Transactional
		public UserDTO update(Long id, UserDTO dto) {
		    User entity = repository.findById(id)
		            .orElseThrow(() -> new com.aprendendoweb.Course.services.exceptions.ResourceNotFoundException("Usuário não encontrado"));
		    entity.setName(dto.getName());
		    entity.setEmail(dto.getEmail());
		    entity.setPhone(dto.getPhone());

		    entity = repository.save(entity);
		    return new UserDTO(entity);
	}
}
