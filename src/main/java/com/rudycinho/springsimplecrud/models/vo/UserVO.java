package com.rudycinho.springsimplecrud.models.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserVO {
	private String name;
	private String lastName;
	private String identification;
	private String address;
	private String phone;
	private String email;
}
