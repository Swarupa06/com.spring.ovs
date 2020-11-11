package com.spring.ovs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ovs.dtos.VotedList;
import com.spring.ovs.exceptions.VoterNotFoundException;
import com.spring.ovs.service.VotedListService;




@RestController

public class VotedListController{

	Logger log = LoggerFactory.getLogger(VotedListController.class);
	
	@Autowired
	private VotedListService vlService;
	
	@GetMapping("/ovs")
	public @ResponseBody List<VotedList> getAllVotedList()
	{
		
		return vlService.getAllVotedList();
	}
	@GetMapping("/ovs/{id}")
	public @ResponseBody VotedList viewVotedListById(@PathVariable("id") int id )throws VoterNotFoundException
	{
		return vlService.viewVotedListById(id);
		
	}
	
	@PostMapping("/ovs")
	public @ResponseBody VotedList addVotedListDetails(@RequestBody VotedList votedList)
	{
		return vlService.addVotedListDetails(votedList);
	}
	
	@PutMapping("/ovs/{id}")
	public @ResponseBody VotedList updateVotedListDetails(@PathVariable("id") int id,@RequestBody VotedList votedList) throws VoterNotFoundException
	{
	return vlService.updateVotedListDetails(id, votedList);
	}
	
	@DeleteMapping("/ovs/{id}")
	public @ResponseBody int deleteVotedList(@PathVariable("id") int id) throws VoterNotFoundException
	{
		return vlService.deleteVotedList(id);
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*@PostMapping(value = {"/ovs" })
public @ResponseBody int castVotedList(@RequestBody VotedList votedList)
{ 
	
	return votedService.castVotedList(votedList);
}

@GetMapping("/{ovs}")
public @ResponseBody  VotedList updateVotedListDetails(@PathVariable int id,@RequestBody VotedList votedList) throws CastedVoteNotFoundException
{
	
	return votedService.updateVotedListDetails(id,votedList);
}



@DeleteMapping("/id")
public @ResponseBody int deletedVotedListDetails(@RequestBody int id) throws CastedVoteNotFoundException
{
	return votedService.deletedVotedListDetails(id);
}

@GetMapping(value= {"/"})
public @ResponseBody List<VotedList>viewVotedList()
{
	List<VotedList> voted=votedService.viewVotedList();
	return voted;
}
@GetMapping("/{id}")
public @ResponseBody int searchByVoterId(@PathVariable int voterId)throws VoterNotFoundException
{
	return votedService.searchByVoterId(voterId);
}
}*/
