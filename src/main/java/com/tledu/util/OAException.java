package com.tledu.util;

public class OAException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public OAException(){
		
	}
	public OAException(String msg){
		super(msg);
	}
}
