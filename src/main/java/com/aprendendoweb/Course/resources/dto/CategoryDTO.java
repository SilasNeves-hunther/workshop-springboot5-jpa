package com.aprendendoweb.Course.resources.dto;

import com.aprendendoweb.Course.entities.Category;

public class CategoryDTO {

	private Integer id;
	private String name;

	public CategoryDTO(Category entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

