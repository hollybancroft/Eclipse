//Holly Bancroft
//7/19/2020
package edu.seminolestate.employees;

import edu.seminolestate.exceptions.InvalidArgumentException;
import edu.seminolestate.payable.Payable;

public abstract class Employee implements Payable {

	private String firstName;
	private String lastName;
	private int iD;
	
	
	public Employee(String newFName, String newLName, int newid) throws InvalidArgumentException{
		this.setFirstName(newFName);
		this.setLastName(newLName);
		this.setiD(newid);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) throws InvalidArgumentException {
		if(firstName != null || firstName.length() > 0) {
			this.firstName = firstName;
			}
		else {
			throw new InvalidArgumentException("You must enter a value for first name.");
		}
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) throws InvalidArgumentException {
		if(lastName != null || lastName.length() > 0) {
			this.lastName = lastName;
		}
		else {
			throw new InvalidArgumentException("You must enter a value for last name");
		}
	}
	public int getiD() {
		return iD;
	}
	
	public void setiD(int iD) throws InvalidArgumentException {
		if(iD > 0) {
		this.iD = iD;
	}
		else {
			throw new InvalidArgumentException("Value must be greater than 0");
			}
		}
	
	public String toString() {
		return getClass() + "First name: " + firstName + "Last name: " + lastName + "ID: " + iD;
	}

		
}
