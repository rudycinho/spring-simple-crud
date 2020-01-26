package com.rudycinho.springsimplecrud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rudycinho.springsimplecrud.models.pojo.User;

/**
 * Interface for defining user-related database operations
 * @author rudy
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>{
	/**
	 * Definition of method to search for all users
	 * @return All users
	 */
	@Query("SELECT u "+
		   "FROM User u")
	public List<User> getAll();
	
	/**
	 * Definition of method to search for a user by his id
	 * @param id User id
	 * @return User 
	 */
	@Query("SELECT u "+
	       "FROM User u "+
		   "WHERE u.id=:id")
	public User get(@Param( "id") int id);
}
