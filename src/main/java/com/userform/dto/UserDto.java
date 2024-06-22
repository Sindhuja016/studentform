package com.userform.dto;



public class UserDto {
	
	private Long Id;
	
	private String name;
	
	private String password;
	
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long long1) {
		Id = long1;
	}

	
	

}
