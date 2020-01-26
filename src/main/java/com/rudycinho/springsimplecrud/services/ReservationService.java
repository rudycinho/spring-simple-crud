package com.rudycinho.springsimplecrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rudycinho.springsimplecrud.models.pojo.Reservation;
import com.rudycinho.springsimplecrud.repositories.ReservationRepository;

/**
 * Class to define reservation services
 * @author rudy
 *
 */
@Service
@Transactional(readOnly = true)
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;

	/**
	 * Method to create a reservation
	 * @param reservation Reservation to created
	 * @return Reservation created
	 */
	@Transactional
	public Reservation create(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	/**
	 * Method to update a reservation
	 * @param reservation Reservation to updated
	 * @return Reservation updated
	 */
	@Transactional
	public Reservation update(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	/**
	 * Method to deleted a reservation
	 * @param reservation Reservation to deleted
	 */
	@Transactional
	public void delete(Reservation reservation) {
		reservationRepository.delete(reservation);
	}
	
	/**
	 * Method to get a reservation by id
	 * @param id Reservation id
	 * @return Reservation
	 */
	public Reservation get(int id) {
		return reservationRepository.get(id);
	}
	
	/**
	 * Method to get all reservations
	 * @return All reservations
	 */
	public List<Reservation> getAll(){
		return reservationRepository.getAll();
	}
}
