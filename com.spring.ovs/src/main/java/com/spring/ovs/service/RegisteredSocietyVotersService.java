package com.spring.ovs.service;
import java.util.ArrayList;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.RegisteredSocietyVoters;
import com.spring.ovs.repository.RegisteredSocietyVotersRepository;



@Service
public class RegisteredSocietyVotersService 
{
	@Autowired
	RegisteredSocietyVotersRepository rsvRepo;
	
	 public int voterRegistration(RegisteredSocietyVoters voter) {
	 rsvRepo.save(voter);
    return voter.getVoterId();
}
	 
	 public RegisteredSocietyVoters updateRegisteredSocietyVotersDetails(int voterId,RegisteredSocietyVoters voter) {
	       	return rsvRepo.save(voter);
	 	}

	 public int deleteRegisteredSocietyVoter(int voterId) {
	       	rsvRepo.deleteById(voterId);
	       	return voterId;
	 	}
	 
	 
	public List<RegisteredSocietyVoters> viewRegisteredVoterList(){
	 {
		List<RegisteredSocietyVoters> voter = new ArrayList<RegisteredSocietyVoters>(); 
		System.out.println("RegisteredSocietyVoters...");
		rsvRepo.findAll().forEach(voter1 -> voter.add(voter1));
		return voter;
	 }
}	
	 
	 public RegisteredSocietyVoters searchByVoterID(int voterId){
	 {
	       	return rsvRepo.findById(voterId).get();
	 }
	  
	 }
	
	}

