package com.aprendendoweb.Course.resources.dto;

import com.aprendendoweb.Course.entities.User;

public class UserDTO {
	
		private Long id;
		private String name;
		private String email;
		private String phone;
		
		public UserDTO() {
		}

		public UserDTO(User entity) {
			this.id = entity.getId();
			this.name = entity.getName();
			this.email = entity.getEmail();
			this.phone = entity.getPhone();
		}

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}

		public String getPhone() {
			return phone;
		}
	}


