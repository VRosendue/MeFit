package com.MeFit.Dto;

import com.MeFit.Models.Users;

public class UsersDto {
	
	//Long id, String username, String email, 
	
	private Long id;
	private String username;
	private String email;
	
	public UsersDto() {}
	
	public UsersDto(Users users) {
		this.id = users.getId();
		this.username = users.getUsername();
		this.email = users.getEmail();
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
