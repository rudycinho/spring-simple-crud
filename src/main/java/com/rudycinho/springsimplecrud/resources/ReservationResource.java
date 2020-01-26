package com.rudycinho.springsimplecrud.resources;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rudycinho.springsimplecrud.models.dto.ReservationDTO;
import com.rudycinho.springsimplecrud.models.pojo.Reservation;
import com.rudycinho.springsimplecrud.models.vo.ReservationVO;
import com.rudycinho.springsimplecrud.services.ReservationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Class representing the reservation web service
 * @author rudy
 *
 */
@RestController
@RequestMapping("/api/reservations")
@Api(tags = "reservation")
public class ReservationResource {
	
	@Autowired
	private ReservationService reservationService;
	
	/**
	 * Method to create reservation
	 * @param reservationVO Visual Object of Reservation
	 * @return ResponseEntity with reservation data or error message with status
	 */
	@PostMapping
	@ApiOperation(value = "Create reservation", notes = "Service to create a new reservation")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Reservation created"),
			@ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<?> create(@RequestBody ReservationVO reservationVO){
		Reservation reservation = new Reservation(reservationVO);
		reservation = reservationService.create(reservation);
		ReservationDTO reservationDTO = new ReservationDTO(reservation);
		return new ResponseEntity<>(reservationDTO,HttpStatus.CREATED);
	}
	
	/**
	 * Method to update a reservation
	 * @param id Reservation id
	 * @param reservationVO Visual Object of Reservation
	 * @return ResponseEntity with reservation data or error message with status
	 */
	@PutMapping("/{id}")	
	@ApiOperation(value = "Update reservation", notes = "Service to update a reservation")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Reservation updated"),
			@ApiResponse(code = 404, message = "Reservation  not found"),
			@ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ReservationVO reservationVO){
		ResponseEntity<?> response;
		Reservation reservation = reservationService.get(id);
		if(reservation==null) {
			Map<String,String> errors = new HashMap<>();
			errors.put("Errors", "The reservation does not exist");
			response = new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
		}else {
			reservation.setReservation(reservationVO);
			reservation = reservationService.update(reservation);
			ReservationDTO reservationDTO = new ReservationDTO(reservation);
			response = new ResponseEntity<>(reservationDTO,HttpStatus.CREATED);
		}
		return response;
	}
	
	/**
	 * Method to deleted a reservation
	 * @param id Reservation id
	 * @return ResponseEntity with reservation data or error message with status
	 */
	@DeleteMapping("/{id}")	
	@ApiOperation(value = "Delete reservation", notes = "Service to delete a reservation")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Reservation deleted"),
			@ApiResponse(code = 404, message = "Reservation not found"),
			@ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		ResponseEntity<?> response;
		Reservation reservation = reservationService.get(id);
		if(reservation==null) {
			Map<String,String> errors = new HashMap<>();
			errors.put("Errors", "The reservation does not exist");
			response = new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
		}else {
			reservationService.delete(reservation);
			ReservationDTO reservationDTO = new ReservationDTO(reservation);
			response = new ResponseEntity<>(reservationDTO,HttpStatus.OK);
		}
		return response;
	}
	
	/**
	 * Method to get a reservation by id
	 * @param id Reservation id
	 * @return ResponseEntity with reservation data or error message with status
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "Get all reservations", notes = "Service to get all reservations")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "All retrieved reservations"),
			@ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<?> get(@PathVariable("id")int id){
		ResponseEntity<?> response;
		Reservation reservation = reservationService.get(id);
		if(reservation==null) {
			Map<String,String> errors = new HashMap<>();
			errors.put("Errors", "The reservation does not exist");
			response = new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
		}else {
			ReservationDTO reservationDTO = new ReservationDTO(reservation);
			response = new ResponseEntity<>(reservationDTO,HttpStatus.OK);
		}
		return response;
	}
	
	/**
	 * Method to get all reservations
	 * @return ResponseEntity with reservations data or error message with status
	 */
	@GetMapping
	@ApiOperation(value = "Get reservation", notes = "Service to get a just reservation")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieved reservation"),
			@ApiResponse(code = 404, message = "Reservation not found"),
			@ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<?> get(){
		ResponseEntity<?> response;
		List<Reservation> reservations = reservationService.getAll();
		if(reservations.size()==0) {
			Map<String,String> errors = new HashMap<>();
			errors.put("Errors", "No reservations");
			response = new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
		}else {
			List<ReservationDTO> reservationsDTO = new LinkedList<>();
			ReservationDTO reservationDTO;
			for(Reservation reservation : reservations) {
				reservationDTO = new ReservationDTO(reservation);
				reservationsDTO.add(reservationDTO);
			}
			response = new ResponseEntity<>(reservationsDTO,HttpStatus.OK);
		}
		return response;
	}
}
