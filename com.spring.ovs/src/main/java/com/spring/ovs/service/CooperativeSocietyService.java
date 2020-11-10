package com.spring.ovs.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.ovs.dtos.CooperativeSociety;

import com.spring.ovs.repository.CooperativeSocietyRepository;

@Service
public class CooperativeSocietyService {
	@Autowired
	CooperativeSocietyRepository csRepo;


public CooperativeSociety addSocietyDetails(CooperativeSociety society)
{
      return csRepo.save(society);
	
}
public CooperativeSociety updateSocietyDetails(CooperativeSociety society)
 {
      return csRepo.save(society);

      	
}
public int deleteSociety(int societyId) 
{
	  csRepo.deleteById(societyId);
	return societyId;
}


public List<CooperativeSociety> getAllCooperativeSocieties()
{
	List<CooperativeSociety> society = new ArrayList<CooperativeSociety>(); 
	System.out.println("Cooperative Society...");
	csRepo.findAll().forEach(society1 -> society.add(society1));
	return society;
}

public CooperativeSociety viewSocietyById(int societyId)
{
      	return csRepo.findById(societyId).get();
}
}
