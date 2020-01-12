package com.rudycinho.springsimplecrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudycinho.springsimplecrud.models.pojo.User;
import com.rudycinho.springsimplecrud.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public User update(User user) {
		return userRepository.save(user);
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public User get(int id) {
		return userRepository.get(id);
	}
	
	public List<User> getAll(){
		return userRepository.getAll();
	}
}
