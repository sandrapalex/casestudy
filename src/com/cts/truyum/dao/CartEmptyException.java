package com.cts.truyum.dao;
import java.lang.Exception;
public class CartEmptyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public CartEmptyException(String message) {
		super(message);
	}
}
