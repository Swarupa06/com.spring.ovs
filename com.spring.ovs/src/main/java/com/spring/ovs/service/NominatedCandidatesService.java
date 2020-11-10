package com.spring.ovs.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.NominatedCandidates;
import com.spring.ovs.repository.NominatedCandidatesRepository;

@Service
public class NominatedCandidatesService 
{
     @Autowired
     NominatedCandidatesRepository ncRepo;

    public List<NominatedCandidates > getAllNominatedCandidates ()
   {
	List<NominatedCandidates > candidate = new ArrayList<NominatedCandidates >(); 
	System.out.println("Nominated Candidates...");
    ncRepo.findAll().forEach(candidate1 -> candidate.add(candidate1));
	return candidate;
   }



public  NominatedCandidates viewNominatedCandidatesById(int candidateId) 
{
      return ncRepo.findById(candidateId).get();
       
}
 


public int addNominatedCandidate(NominatedCandidates candidate)
{
      ncRepo.save(candidate);
	return candidate.getCandidateId();
}

public int deleteNominatedCandididates(int candidateId)
{
	  ncRepo.deleteById(candidateId);
	return candidateId;
}



public NominatedCandidates updateNominatedCandidateDetails(int candidateId,NominatedCandidates candidate) {
      	return ncRepo.save(candidate);
	}


 

}




















































/*public int  addNominatedCandidatesDetails(NominatedCandidates candidate) throws IllegalArgumentException
{
	try
	{
		 ncRepo.save(candidate);
	     return candidate.getCandidateId();
	}
	catch(IllegalArgumentException e)
	{
	    System.out.println("Nominated candidate could not be added");
		e.printStackTrace();
	}
	return candidate.getCandidateId();
 
}


public  NominatedCandidates updateNominatedCandidateDetails(int candidateId,NominatedCandidates candidate) throws NominatedCandidateNotFoundException
{

      Optional<NominatedCandidates> repCandidate = ncRepo.findById(candidateId);

        if (repCandidate.isPresent()) {

        NominatedCandidates candidateToBeUpdated = repCandidate.get();
	    candidateToBeUpdated.setCandidateId(candidate.getCandidateId());
	    candidateToBeUpdated.setNominationFormNo(candidate.getNominationFormNo());
	    candidateToBeUpdated.setSociety_Voter(candidate.getSociety_Voter());
	   
	    return ncRepo.save(candidateToBeUpdated);
      }
      else
      {
			throw new NominatedCandidateNotFoundException("No record present with the given Id to update...Please enter valid id to update");

      }
  }

public int deleteNominatedCandididate(int candidateId) throws NominatedCandidateNotFoundException
{
	 Optional<NominatedCandidates> repCandidate = ncRepo.findById(candidateId);
		 
	  if(repCandidate.isPresent())
	   {
	      ncRepo.deleteById(candidateId);
         System.out.println("candidate details are deleted Successfully");
		}
	    else
		{
		    throw new NominatedCandidateNotFoundException("Enter valid Id to be deleted");
		}
	    return candidateId;
}*/


