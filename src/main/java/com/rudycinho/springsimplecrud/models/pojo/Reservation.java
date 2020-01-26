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

import com.rudycinho.springsimplecrud.models.vo.ReservationVO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "reservations")
/**
 * Class representing Reservation name
 * @author rudy
 *
 */
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
	
	/**
	 * Construct a empty reservation
	 */
	public Reservation() {}
	
	/**
	 * Construct a reservation with data from visual object
	 * @param reservationVO visual object that content the data
	 */
	public Reservation(ReservationVO reservationVO) {
		setReservation(reservationVO);
	}
	
	/**
	 * Method that modifies the reservation data from a visual object
	 * @param reservationVO visual object that content the data
	 */
	public void setReservation(ReservationVO reservationVO) {
		this.entryDate    = reservationVO.getEntryDate();
		this.departureDate= reservationVO.getDepartureDate();
		this.numberPersons= reservationVO.getNumberPersons();
		this.descripcion  = reservationVO.getDescripcion();
	}
}
