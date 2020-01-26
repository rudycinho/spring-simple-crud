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

import com.rudycinho.springsimplecrud.models.dto.UserDTO;
import com.rudycinho.springsimplecrud.models.pojo.User;
import com.rudycinho.springsimplecrud.models.vo.UserVO;
import com.rudycinho.springsimplecrud.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Class representing the user web service
 * @author rudy
 *
 */
@RestController
@RequestMapping("/api/users")
@Api(tags = "user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Method to create a user
	 * @param userVO Visual Object of User
	 * @return ResponseEntity with user data or error message with status
	 */
	@PostMapping
	@ApiOperation(value = "Create user", notes = "Service to create a new user")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "User created"),
			@ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<?> create(@RequestBody UserVO userVO){
		User user = new User(userVO);
		user = userService.create(user);
		UserDTO userDTO = new UserDTO(user);
		return new ResponseEntity<>(userDTO,HttpStatus.CREATED);
	}
	
	/**
	 * Method to update a user
	 * @param id User id
	 * @param userVO Visual Object of User
	 * @return ResponseEntity with user data or error message with status
	 */
	@PutMapping("/{id}")
	@ApiOperation(value = "Update user", notes = "Service to update a user")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "User updated"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody UserVO userVO){
		ResponseEntity<?> response;
		User user = userService.get(id);
		if(user==null) {
			Map<String,String> errors = new HashMap<>();
			errors.put("Errors", "The user does not exist");
			response = new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
		}else {
			user.setUser(userVO);
			user = userService.update(user);
			UserDTO userDTO = new UserDTO(user);
			response = new ResponseEntity<>(userDTO,HttpStatus.CREATED);
		}
		return response;
	}
	
	/**
	 * Method to deleted a user
	 * @param id User id
	 * @return  ResponseEntity with user data or error message with status
	 */
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete user", notes = "Service to delete a user")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "User deleted"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		ResponseEntity<?> response;
		User user = userService.get(id);
		if(user==null) {
			Map<String,String> errors = new HashMap<>();
			errors.put("Errors", "The user does not exist");
			response = new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
		}else {
			userService.delete(user);
			UserDTO userDTO = new UserDTO(user);
			response = new ResponseEntity<>(userDTO,HttpStatus.OK);
		}
		return response;
	}
	
	/**
	 * Method to get a user by id
	 * @param id User id
	 * @return ResponseEntity with user data or error message with status
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "Get all users", notes = "Service to get all users")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "All retrieved user"),
			@ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<?> get(@PathVariable("id")int id){
		ResponseEntity<?> response;
		User user = userService.get(id);
		if(user==null) {
			Map<String,String> errors = new HashMap<>();
			errors.put("Errors", "The user does not exist");
			response = new ResponseEntity<>(errors,HttpStatus.OK);
		}else {
			UserDTO userDTO = new UserDTO(user);
			response = new ResponseEntity<>(userDTO,HttpStatus.OK);
		}
		return response;
	}
	
	/**
	 * Method to get all users
	 * @return ResponseEntity with users data or error message with status
	 */
	@GetMapping
	@ApiOperation(value = "Get user", notes = "Service to get a just user")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieved user"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 400, message = "Bad request")
	})
	public ResponseEntity<?> get(){
		ResponseEntity<?> response;
		List<User> users = userService.getAll();
		if(users.size()==0) {
			Map<String,String> errors = new HashMap<>();
			errors.put("Errors", "No users");
			response = new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
		}else {
			List<UserDTO> usersDTO = new LinkedList<>();
			UserDTO userDTO;
			for(User user : users) {
				userDTO = new UserDTO(user);
				usersDTO.add(userDTO);
			}
			response = new ResponseEntity<>(usersDTO,HttpStatus.OK);
		}
		return response;
	}
}
