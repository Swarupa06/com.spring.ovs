package com.spring.swagger.ovs;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.ovs.controllers.NominatedConditesController;
import com.spring.ovs.dtos.NominatedCandidates;
import com.spring.ovs.exceptions.NominatedCandidateNotFoundException;
import com.spring.ovs.service.NominatedCandidatesService;


@ExtendWith(MockitoExtension.class)
public class NominatedCandidatesTest
{
    
	@Mock
	NominatedCandidatesService noServices;
	

	@InjectMocks
	NominatedConditesController noController;

	@Test
	public void testaddNominatedCandidate()
	{
		
		NominatedCandidates candidate =new NominatedCandidates();
		Mockito.when(noController.addNominatedCandidate(candidate)).thenReturn(candidate);
		assertEquals(candidate,noController.addNominatedCandidate(candidate));
	 }
	 @Test
	 public void testGetAllNominatedCandidates()
	 {
	        List<NominatedCandidates> candidate=new ArrayList<NominatedCandidates>();
	       Mockito.when(noController.getAllNominatedCandidates()).thenReturn(candidate);
	        assertEquals(candidate,noController.getAllNominatedCandidates());

	   }
	 @Test
	 public void testviewNominatedCandidatesById() throws NominatedCandidateNotFoundException 
	 {
		 NominatedCandidates candidate=new NominatedCandidates();
		 int candidateId=1;
		 Mockito.when(noController.viewNominatedCandidatesById(candidateId)).thenReturn(candidate);
	     assertEquals(candidate,noController.viewNominatedCandidatesById(candidateId));
 
	 }
	 @Test
	 public void testupdateNominatedCandidateDetails()throws NominatedCandidateNotFoundException
	 {
		NominatedCandidates candidate=new NominatedCandidates();
		int candidateId=1;
		Mockito.when(noController. updateNominatedCandidateDetails(candidateId, candidate)).thenReturn(candidate);
		assertEquals(candidate,noController. updateNominatedCandidateDetails(candidateId, candidate));

	}
	 
	 @Test
	 public void testdeleteNominatedCandididates()throws NominatedCandidateNotFoundException
	 {
	 	
		 int candidateId=1;
		Mockito.when(noController.deleteNominatedCandididates(candidateId)).thenReturn(candidateId);
	 	assertEquals(candidateId,noController.deleteNominatedCandididates(candidateId));
	 	
	 }


}