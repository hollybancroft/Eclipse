// Holly Bancroft
// 7/19/2020
package edu.seminolestate.employees;

import edu.seminolestate.exceptions.InvalidArgumentException;
import edu.seminolestate.payable.Payable;

public class Manager extends Employee implements Payable {

	private double annualSalary;
	
	public Manager(String newFName, String newLName, int newid, double annualSalary) throws InvalidArgumentException {
		super(newFName, newLName, newid);
		this.setAnnualSalary(annualSalary);
	}
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	public void setAnnualSalary(double annualSalary) throws InvalidArgumentException{
		if(annualSalary > 0) {
			this.annualSalary = annualSalary;
		}
		else {
			throw new InvalidArgumentException("Annual salary must be greater than 0");
		}
	}
	
	@Override
	public double computeAmountToPay() {
		return annualSalary / 12;
	}
	
	public String toString() {
		return getClass() + super.toString() + "Annual Salary: " + annualSalary;
	}
}
