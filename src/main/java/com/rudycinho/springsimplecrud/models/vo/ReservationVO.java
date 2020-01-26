package com.rudycinho.springsimplecrud.models.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Visual Object representing the reservation
 * @author rudy
 *
 */
@Setter
@Getter
public class ReservationVO {
	private Date entryDate;
	private Date departureDate;
	private int numberPersons;
	private String descripcion;	
}
