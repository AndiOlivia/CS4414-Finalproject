﻿package com.jida.client;

public class InvalidUserException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidUserException() {
		super();
	}

	public InvalidUserException(String message, Throwable cause) {
		super(message, cause);
	}
 
	public InvalidUserException(String message) {
		super(message);
	}

	public InvalidUserException(Throwable cause) {
		super(cause);
	}

}
