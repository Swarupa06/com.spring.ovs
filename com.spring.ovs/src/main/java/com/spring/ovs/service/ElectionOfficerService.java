package com.spring.ovs.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.ElectionOfficer;
import com.spring.ovs.repository.ElectionOfficerRepository;


@Service
public class ElectionOfficerService 
{
	@Autowired
	ElectionOfficerRepository elRepo;
	 
	public List<ElectionOfficer> getAllElectionOfficers()
	 {
		List<ElectionOfficer> officer = new ArrayList<ElectionOfficer>(); 
		System.out.println("Election Officers...");
		elRepo.findAll().forEach(officer1 -> officer.add(officer1));
		return officer;
	 }
	 public ElectionOfficer viewElectionOfficerById(int officerId) 
	 {
	       	return elRepo.findById(officerId).get();
	 }
	  
	 public ElectionOfficer addElectionOfficerDetails(ElectionOfficer officer)
	 {
	      return elRepo.save(officer);
	
	 }
	 
	 public int deleteElectionOfficer(int officerId)
	 {
		  elRepo.deleteById(officerId);
		return officerId;
	 }
	 
	 public ElectionOfficer updateElectionOfficerDetails(int officerId,ElectionOfficer officer) {
	       	return elRepo.save(officer);
	 	}


    
}
