package com.rudycinho.springsimplecrud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rudycinho.springsimplecrud.models.pojo.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	@Query("SELECT r FROM Reservation r")
	public List<Reservation> getAll();
	
	@Query("SELECT r FROM Reservation r WHERE r.id=:id")
	public Reservation get( @Param("id") int id);
}
