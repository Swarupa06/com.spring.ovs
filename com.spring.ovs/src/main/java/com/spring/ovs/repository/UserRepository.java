package com.spring.ovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ovs.dtos.User;


public interface UserRepository extends JpaRepository<User, Integer> {



}


