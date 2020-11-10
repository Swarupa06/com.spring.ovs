package com.spring.ovs.service;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.VotedList;
import com.spring.ovs.repository.VotedListRepository;

 
//defining the business logic
@Service
public class VotedListService {
	@Autowired
	VotedListRepository vlRepo;
	
	
	public List<VotedList> getAllVotedList()
	{
		List<VotedList> votedList=new ArrayList<VotedList>();
		System.out.println("VotedLists.........");
		vlRepo.findAll().forEach(votedList1-> votedList.add(votedList1));
		return votedList;
	}
	public VotedList viewVotedListById(int id)
	{
		return vlRepo.findById(id).get();
	}
	public VotedList addVotedListDetails(VotedList votedList)
	{
		return vlRepo.save(votedList);
	
	}
	public int deleteVotedList(int id)
	
	{
		vlRepo.deleteById(id);
		return id;
	}
	public VotedList updateVotedListDetails(int id,VotedList votedList)
	{
		return vlRepo.save(votedList);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

 	
 /*	//@Autowired
	private VotedListRepository votedRepo;
	private Integer votedId;
 
	public int castVotedList(VotedList votedList) throws IllegalArgumentException
	{
	 try
	 {
		 votedRepo.save(votedList);
		return votedList.getId();
	}
	 catch(IllegalArgumentException e)
	 {
		 System.out.println("castvotedlist could not be added"); 
		 e.printStackTrace();
			return votedList.getId();
			
	 }
	}
	public VotedList updateVotedListDetails(int id,VotedList votedList) throws CastedVoteNotFoundException {
	
	
        
		Optional <VotedList> repVotedList = votedRepo.findById(id);

		if (repVotedList.isPresent()) {

			VotedList votedlistToBeUpdated = repVotedList.get();
			votedlistToBeUpdated.setId(votedList.getId());
			votedlistToBeUpdated.setPollingDateTime(votedList.getPollingDateTime());
			votedlistToBeUpdated.setSociety(votedList.getSociety());
			votedlistToBeUpdated.setVoter(votedList.getVoter());
			votedlistToBeUpdated.setCandidate(votedList.getCandidate());

			return  votedRepo.save(votedlistToBeUpdated);

        }
		else
        {
			throw new CastedVoteNotFoundException("votedlist could not be updated");
        	
	     }

		
	}
 
	public int deletedVotedListDetails(int id) throws CastedVoteNotFoundException  {
		
		{
			Optional <VotedList> repVotedList = votedRepo.findById(id);
			if (repVotedList.isPresent())
			{
				votedRepo.deleteById(id);
				System.out.println("votedlist id are deletes successfully");
			}
			else
			{
				throw new CastedVoteNotFoundException("enter valid id to be deleted");
			}
			return id;

		}
	}
	
	public List<VotedList> viewVotedList() {
		System.out.println("voters...");
		return votedRepo.findAll();
	}
	
	public int searchByVoterId(int voterId) throws VoterNotFoundException{
		Optional <VotedList> repVotedList = votedRepo.findById(votedId);
		if (repVotedList.isPresent())
		{
			votedRepo.findById(voterId);
			System.out.println("votedlist voterid are searched successfully");
		}
		else
		{
			throw new VoterNotFoundException("enter valid id to be searched");
		}
		return voterId;
	}
}*/
