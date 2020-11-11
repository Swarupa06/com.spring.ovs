package com.ovs.spring.demo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;



public class ElectionOfficerTest
{
  ElectionOfficerService service=mock(ElectionOfficerService.class);
  ElectionOfficer officer=new ElectionOfficer();
	
	@Test
	void testAdd() 
	{
		
		when(service.addElectionOfficerDetails(officer)).thenReturn(officer.getOfficerId());
		assertEquals(officer.getOfficerId(),service.addElectionOfficerDetails(officer));
		
	}

	@Test
	void testUpdate() 
	{
		int officerId = 1;
		when(service.updateElectionOfficerDetails(officer)).thenReturn(officerId);
		assertEquals(officerId,service.updateElectionOfficerDetails(officer));
	}

	@Test
	void testDelete()
	{
		int officerId = 1;
		when(service.deleteElectionOfficer(officerId)).thenReturn(officerId);
		assertEquals(officerId,service.deleteElectionOfficer(officerId));
	}
}
