package com.spring.ovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ovs.dtos.ElectionOfficer;

public interface ElectionOfficerRepository extends JpaRepository<ElectionOfficer, Integer> {

	

}
