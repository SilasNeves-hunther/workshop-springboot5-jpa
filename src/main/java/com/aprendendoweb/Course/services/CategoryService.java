package com.aprendendoweb.Course.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aprendendoweb.Course.entities.Category;
import com.aprendendoweb.Course.repositories.CategoryRepository;
import com.aprendendoweb.Course.resources.dto.CategoryDTO;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<CategoryDTO> findAll(){
        return repository.findAll()
                         .stream()
                         .map(CategoryDTO::new)
                         .collect(Collectors.toList());
    }

    @Transactional
    public CategoryDTO findById(Long id) {
        Category category = repository.findById(id)
                                      .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return new CategoryDTO(category);
    }
}

