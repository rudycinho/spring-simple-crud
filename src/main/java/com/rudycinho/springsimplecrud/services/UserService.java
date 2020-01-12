package com.rudycinho.springsimplecrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rudycinho.springsimplecrud.models.pojo.User;
import com.rudycinho.springsimplecrud.repositories.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User create(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	public User update(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
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
