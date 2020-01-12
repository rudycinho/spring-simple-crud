package com.rudycinho.springsimplecrud.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@RestController
@RequestMapping("/api/user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody UserVO userVO){
		User user = new User(userVO);
		user = userService.create(user);
		UserDTO userDTO = new UserDTO(user);
		return new ResponseEntity<>(userDTO,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
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
	
}
