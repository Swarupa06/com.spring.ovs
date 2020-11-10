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
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.spring.ovs.controllers.ElectionOfficerController;
import com.spring.ovs.dtos.ElectionOfficer;
import com.spring.ovs.exceptions.ElectionOfficerNotFoundException;
import com.spring.ovs.service.ElectionOfficerService;





@ExtendWith(MockitoExtension.class)
public class ElectionOfficerTest{
    
	@Mock
	ElectionOfficerService eoServices;
	

	@InjectMocks
	ElectionOfficerController eoController;

	@Test
	public void testAddElectionOfficerDetails() {
		
		       ElectionOfficer officer =new ElectionOfficer();
				Mockito.when(eoController.addElectionOfficerDetails(officer)).thenReturn(officer);
		        assertEquals(officer,eoController.addElectionOfficerDetails(officer));
		    }
	 @Test
	    public void testGetAllElectionOfficers() {
	        List<ElectionOfficer> officer=new ArrayList<ElectionOfficer>();
	       Mockito.when(eoController.getAllElectionOfficers()).thenReturn(officer);
	        assertEquals(officer,eoController.getAllElectionOfficers());

	    }
	 @Test
	 public void testElectionOfficerById() throws ElectionOfficerNotFoundException {
		 ElectionOfficer officer=new ElectionOfficer();
		 int id=1;
		 Mockito.when(eoController.viewElectionOfficerById(id)).thenReturn(officer);
	        assertEquals(officer,eoController.viewElectionOfficerById(id));

		 
	 }
	/* @Test
		public void testUpdateElectionOfficerDetails()
		{
		        ElectionOfficer officer=new ElectionOfficer();
				officer.setPassword("Rachana09");
			    eoController.updateSurveyor(0, officer);
				Assertions.assertEquals("Rachana09", adminRecord1.getPassword());
				Assertions.assertNotEquals(" ",adminRecord1.getUsername());
			
		}*/

}

