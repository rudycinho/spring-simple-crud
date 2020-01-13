package com.rudycinho.springsimplecrud.models.dto;

import java.util.Date;

import com.rudycinho.springsimplecrud.models.pojo.Reservation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationDTO {
	private int id;
	private Date entryDate;
	private Date departureDate;
	private int numberPersons;
	private String descripcion;
	
	public ReservationDTO(Reservation reservation) {
		this.id            = reservation.getId();
		this.entryDate     = reservation.getEntryDate();
		this.departureDate = reservation.getDepartureDate();
		this.numberPersons = reservation.getNumberPersons();
		this.descripcion   = reservation.getDescripcion();
	}
}
