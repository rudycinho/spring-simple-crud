package com.rudycinho.springsimplecrud.models.dto;

import com.rudycinho.springsimplecrud.models.pojo.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
	private int id;
	private String name;
	private String lastName;
	private String identification;
	private String address;
	private String phone;
	private String email;
	
	public UserDTO(User user) {
		this.id             = user.getId();
		this.name           = user.getName();
		this.lastName       = user.getLastName();
		this.identification = user.getIdentification();
		this.address        = user.getAddress();
		this.phone          = user.getPhone();
		this.email          = user.getEmail();
	}
}



