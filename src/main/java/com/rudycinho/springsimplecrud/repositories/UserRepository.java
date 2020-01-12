package com.rudycinho.springsimplecrud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rudycinho.springsimplecrud.models.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT u "+
		   "FROM User u")
	public List<User> getAll();
	
	@Query("SELECT u "+
	       "FROM User u "+
		   "WHERE u.id=:id")
	public User get(@Param( "id") int id);
}
