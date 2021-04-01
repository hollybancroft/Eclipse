//Holly Bancroft
//7/19/2020
package edu.seminolestate.employees;

import edu.seminolestate.exceptions.InvalidArgumentException;
import edu.seminolestate.payable.Payable;

public class HourlyEmployee extends Employee implements Payable{
	private double hoursWorked;
	private double payRate;
	
	public HourlyEmployee(String newFName, String newLName, int newid, double newHours, double newRate) throws InvalidArgumentException {
		super(newFName, newLName, newid);
		
		this.setHoursWorked(newHours);
		this.setPayRate(newRate);
	}
	
	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) throws InvalidArgumentException {
		if(hoursWorked > 0) {
			this.hoursWorked = hoursWorked;
		}
		else {
			throw new InvalidArgumentException("Hours worked must be greater than 0");
		}
	}



	public double getPayRate() {
		return payRate;
	}



	public void setPayRate(double payRate) throws InvalidArgumentException {
		if(payRate > 0) {
			this.payRate = payRate;
		}
		else {
			throw new InvalidArgumentException("Payrate must be greater than 0");
		}
	}


	@Override
	public double computeAmountToPay() {
		return hoursWorked * payRate;
	}
	
	public String toString() {
		return getClass() + super.toString() + "Hours worked: " + hoursWorked 
				+ "Pay rate: " + payRate;
	}
	
}
