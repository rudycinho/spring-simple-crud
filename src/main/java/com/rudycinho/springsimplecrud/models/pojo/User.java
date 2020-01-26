package com.rudycinho.springsimplecrud.models.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.rudycinho.springsimplecrud.models.vo.UserVO;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")
/**
 * Class representing User name
 * @author rudy
 *
 */
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(unique = true, nullable = false)
	private String identification;
	
	@Column(nullable = true)
	private String address;
	
	@Column(nullable = true)
	private String phone;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "user")
	private Set<Reservation> reservations;
	
	/**
	 * Construct a empty user
	 */
	public User() {}
	
	/**
	 * Construct a user with data from visual object
	 * @param userVO visual object that content the data
	 */
	public User(UserVO userVO) {
		setUser(userVO);
	}
	
	/**
	 * Method that modifies the user data from a visual object
	 * @param userVO visual object that content the data
	 */
	public  void setUser(UserVO userVO) {
		this.name           = userVO.getName();
		this.lastName       = userVO.getName();
		this.identification = userVO.getIdentification();
		this.address        = userVO.getAddress();
		this.phone          = userVO.getPhone();
		this.email          = userVO.getEmail();
	}
}
