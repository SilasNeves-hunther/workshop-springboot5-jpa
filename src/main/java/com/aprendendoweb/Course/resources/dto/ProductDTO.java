package com.aprendendoweb.Course.resources.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.aprendendoweb.Course.entities.Product;

public class ProductDTO {
	private Integer id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	private List<CategoryDTO> categories;

	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();

		this.categories = entity.getCategories().stream().map(CategoryDTO::new).collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}
}
