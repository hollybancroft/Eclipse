//Holly Bancroft
// 7/19/2020
package edu.semionlestate.bill;

import java.time.DateTimeException;
import java.time.LocalDate;

import edu.seminolestate.exceptions.InvalidArgumentException;
import edu.seminolestate.payable.Payable;

public class Bill implements Payable{

	private String vendorName;
	private double amountOwed;
	private LocalDate dueDate;
	
	public Bill(String vendor, double amount, LocalDate dueDate) throws InvalidArgumentException {
		this.setVendorName(vendor);
		this.setAmountOwed(amount);
		this.setDueDate(dueDate);
	}
	@Override
	public double computeAmountToPay() {
		
		return amountOwed;
	}


	public String getVendorName() {
		return vendorName;
	}


	public void setVendorName(String vendorName) throws InvalidArgumentException{
		if(vendorName != null || vendorName.length() >= 1) {
			this.vendorName = vendorName;
		}
		else {
			throw new InvalidArgumentException("Vendor name must have a length greater 0.");
		}
	}


	public double getAmountOwed() {
		return amountOwed;
	}


	public void setAmountOwed(double amountOwed) throws InvalidArgumentException {
		if(amountOwed > 0) {
			this.amountOwed = amountOwed;
			}
		else {
			throw new InvalidArgumentException("Amount owed must be greater than 0.");
		}
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) throws InvalidArgumentException {
		if(dueDate != null) {
			this.dueDate = dueDate;
			}
		else {
			throw new InvalidArgumentException("Due date can not be null.");
		}
	}
	
	public void setDueDate(int newYear, int newMonth, int newDay) throws DateTimeException {
		try {
		this.dueDate = LocalDate.of(newYear, newMonth, newDay);
		}
		catch(DateTimeException e) {
			System.out.println("You must enter a valid year, month, and day");
		}
		
	}
	
	public String toString() {
		return getClass() + "Vendor name: " + vendorName + "Amount owed: "
	+ amountOwed + "Due Date: " + dueDate;
	
	}
	
}
