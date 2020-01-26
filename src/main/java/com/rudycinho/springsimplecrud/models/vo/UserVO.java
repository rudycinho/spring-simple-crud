package com.rudycinho.springsimplecrud.models.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * Visual Object representing the user
 * @author rudy
 *
 */
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
