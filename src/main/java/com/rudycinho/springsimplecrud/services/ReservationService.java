package com.rudycinho.springsimplecrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudycinho.springsimplecrud.models.pojo.Reservation;
import com.rudycinho.springsimplecrud.repositories.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	public Reservation create(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	public Reservation update(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
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
