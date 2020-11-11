package com.ovs.spring.demo;

public class DuplicateRecordException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public  DuplicateRecordException(String message)
	{
		super(message);
	}
}
