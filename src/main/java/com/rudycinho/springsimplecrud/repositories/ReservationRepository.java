package com.rudycinho.springsimplecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudycinho.springsimplecrud.models.pojo.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
