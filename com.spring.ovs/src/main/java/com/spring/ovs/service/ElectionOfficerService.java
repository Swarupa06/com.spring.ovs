package com.ovs.spring.demo;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
	  
	 public int addElectionOfficerDetails(ElectionOfficer officer)
	 {
	      elRepo.save(officer);
	      return officer.getOfficerId();
	
	 }
	 
	 public int updateElectionOfficerDetails(ElectionOfficer officer)
	 {
	       	elRepo.save(officer);
		return officer.getOfficerId();
	       	
	 }
	
	 public int deleteElectionOfficer(int officerId)
	 {
		  elRepo.deleteById(officerId);
		return officerId;
	 }
	 
    
}
