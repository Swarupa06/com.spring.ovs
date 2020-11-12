package com.spring.ovs.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.swagger.ovs.dtos.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	

	List<User> findAll();
	void deleteById(int userId);
	
}


