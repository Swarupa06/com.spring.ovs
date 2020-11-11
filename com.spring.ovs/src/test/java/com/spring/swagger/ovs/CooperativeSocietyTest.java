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

import com.spring.ovs.controllers.CooperativeSocietyController;
import com.spring.ovs.dtos.CooperativeSociety;
import com.spring.ovs.exceptions.SocietyNotFoundException;
import com.spring.ovs.service.CooperativeSocietyService;


@ExtendWith(MockitoExtension.class)
public class CooperativeSocietyTest
{
    
	@Mock
	CooperativeSocietyService  csServices;
	

	@InjectMocks
	CooperativeSocietyController  csController;

	
	@Test
	public void testaddSocietyDetails()
	{
		
		CooperativeSociety society =new CooperativeSociety();   
		Mockito.when(csController.addSocietyDetails(society)).thenReturn(society);
        assertEquals(society,csController.addSocietyDetails(society));
        
	}
	
	 @Test
	 public void testGetAllCooperativeSocieties()
	 {
	        List<CooperativeSociety> society=new ArrayList<CooperativeSociety>();
	       Mockito.when(csController.getAllCooperativeSocieties()).thenReturn(society);
	        assertEquals(society,csController.getAllCooperativeSocieties());

	 }
	 
	 @Test
	 public void testviewSocietyById() throws SocietyNotFoundException 
	 {
		 CooperativeSociety society=new CooperativeSociety();
		 
		 int id = 1;
		Mockito.when(csController.viewSocietyById(id)).thenReturn(society);
	     assertEquals(society,csController.viewSocietyById(id));
		 
	 }
	 
	 @Test
	 public void testupdateSocietyDetails()throws SocietyNotFoundException
	 {
		 CooperativeSociety society=new  CooperativeSociety();
		Mockito.when(csController.updateSocietyDetails(society)).thenReturn(society);
		assertEquals(society,csController.updateSocietyDetails(society));

	}	
	 
	 @Test
	 public void testdeleteSociety() throws SocietyNotFoundException
	 {
	 	
		int societyId = 1;
		Mockito.when(csController.deleteSociety(societyId)).thenReturn(societyId);
	 	assertEquals(societyId,csController.deleteSociety(societyId));
	 	
	 }
	 
}
