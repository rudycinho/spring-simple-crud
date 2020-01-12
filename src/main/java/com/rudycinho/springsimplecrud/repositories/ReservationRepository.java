package com.rudycinho.springsimplecrud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rudycinho.springsimplecrud.models.pojo.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	@Query("Select r"+
		   "from Reservation r")
	public List<Reservation> getAll();
	
	@Query("Select r"+
	       "from Reservation r"+
		   "where r.id :=id")
	public Reservation get( @Param("id") int id);
}
