package com.rudycinho.springsimplecrud.models.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id; 
	
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(unique = true)
	private String identification;
	
	@Column(nullable = true)
	private String address;
	
	@Column(nullable = true)
	private String phone;
	
	@Column(unique = true)
	private String email;
	
	@OneToMany(mappedBy = "user")
	private Set<Reservation> reservations;
	
	public User() {}
}
