package com.aprendendoweb.Course.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aprendendoweb.Course.entities.Product;
import com.aprendendoweb.Course.repositories.ProductRepository;
import com.aprendendoweb.Course.resources.dto.ProductDTO;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<ProductDTO> findAll(){
        return repository.findAll()
                         .stream()
                         .map(ProductDTO::new)
                         .collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id)
                                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return new ProductDTO(product);
    }
}
