package com.rudycinho.springsimplecrud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rudycinho.springsimplecrud.models.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("Select u"+
		   "from User u")
	public List<User> getAll();
	
	@Query("Select u"+
	       "from User u"+
		   "where u.id =:id")
	public User get(@Param( "id") int id);
}
