package com.rudycinho.springsimplecrud.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
