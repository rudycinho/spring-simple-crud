package com.rudycinho.springsimplecrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rudycinho.springsimplecrud.models.pojo.User;
import com.rudycinho.springsimplecrud.repositories.UserRepository;

/**
 * Class to define user services
 * @author rudy
 *
 */
@Service
@Transactional(readOnly = true)
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * Method to create a user
	 * @param user User to create
	 * @return User created
	 */
	@Transactional
	public User create(User user) {
		return userRepository.save(user);
	}
	
	/**
	 * Method to update a user
	 * @param user User to updated
	 * @return User updated
	 */
	@Transactional
	public User update(User user) {
		return userRepository.save(user);
	}
	
	/**
	 * Method to deleted a user
	 * @param user User to deleted
	 */
	@Transactional
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	/**
	 * Method to get a user by id
	 * @param id User id
	 * @return User
	 */
	public User get(int id) {
		return userRepository.get(id);
	}
	
	/**
	 * Method to get all users
	 * @return All user
	 */
	public List<User> getAll(){
		return userRepository.getAll();
	}
}
