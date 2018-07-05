package com.sound.exception;

public class WSSException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5658292711139683005L;
	
	public WSSException(String message) {
        super(message);
    }

    public WSSException(String message, Throwable cause) {
        super(message, cause);
    }

}
