package com.rudycinho.springsimplecrud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rudycinho.springsimplecrud.models.pojo.Reservation;

/**
 * Interface for defining reservation-related database operations
 * @author rudy
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	/**
	 * Definition of method to search for all reservations
	 * @return All reservation
	 */
	@Query("SELECT r FROM Reservation r")
	public List<Reservation> getAll();
	
	/**
	 * Definition of method to search for a reservation by his id
	 * @param id Reservation id
	 * @return Reservation
	 */
	@Query("SELECT r FROM Reservation r WHERE r.id=:id")
	public Reservation get( @Param("id") int id);
}
