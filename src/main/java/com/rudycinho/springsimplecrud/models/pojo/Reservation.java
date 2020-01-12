package com.rudycinho.springsimplecrud.models.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "entry_date")
	@Temporal(TemporalType.DATE)
	private Date entryDate;
	
	@Column(name = "departure_date")
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	
	@Column(name = "number_persons")
	private int numberPersons;
	
	@Column(nullable = true)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	public Reservation() {}
}
