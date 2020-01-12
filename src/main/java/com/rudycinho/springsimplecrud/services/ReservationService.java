package com.rudycinho.springsimplecrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rudycinho.springsimplecrud.models.pojo.Reservation;
import com.rudycinho.springsimplecrud.repositories.ReservationRepository;

@Service
@Transactional(readOnly = true)
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;

	@Transactional
	public Reservation create(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	@Transactional
	public Reservation update(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	@Transactional
	public void delete(Reservation reservation) {
		reservationRepository.delete(reservation);
	}
	
	public Reservation get(int id) {
		return reservationRepository.get(id);
	}
	
	public List<Reservation> getAll(){
		return reservationRepository.getAll();
	}
}
