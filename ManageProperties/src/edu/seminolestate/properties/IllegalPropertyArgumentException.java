//Holly Bancroft
// 8/1/2020
package edu.seminolestate.properties;

public class IllegalPropertyArgumentException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalPropertyArgumentException() {
		super("Illegal property agrument.");
	}
	
	public IllegalPropertyArgumentException(String message) {
		super(message);
	}
}
