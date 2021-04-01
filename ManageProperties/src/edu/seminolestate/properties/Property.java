//Holly Bancroft
// 8/1/2020
package edu.seminolestate.properties;

import java.lang.Comparable;
import java.io.Serializable;

public abstract class Property implements Serializable, Comparable<Property>{//make comparable
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int PropertyID;
	private String address;
	private double numberOfBaths;
	private int numberOfBedrooms;
	
	
	public Property(int newPropertyID, String newAddress, double newNumberOfBaths, int newNumberOfBedrooms) {
		this.PropertyID = newPropertyID;
		this.address = newAddress;
		this.numberOfBaths = newNumberOfBaths;
		this.numberOfBedrooms = newNumberOfBedrooms;
	}

	public int getPropertyID() {
		return PropertyID;
	}

	public void setPropertyID(int propertyID) throws IllegalPropertyArgumentException{
		if(propertyID > 0) {
			PropertyID = propertyID;
		}
		else {
			throw new IllegalPropertyArgumentException("Property ID value must be greater than 0");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) throws IllegalPropertyArgumentException {
		if(address != null && address.length() > 0) {
		this.address = address;
		}
		else {
			throw new IllegalPropertyArgumentException("Address can not be null and must have length greater than 0.");
		}
	}

	public double getNumberOfBaths() {
		return numberOfBaths;
	}

	public void setNumberOfBaths(double numberOfBaths) throws IllegalPropertyArgumentException{
		if(numberOfBaths > 0) {
			this.numberOfBaths = numberOfBaths;
		}
		else {
			throw new IllegalPropertyArgumentException("Number of baths must be greater than 0");
		}
	}

	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(int numberOfBedrooms) throws IllegalPropertyArgumentException{
		if(numberOfBedrooms > 0) {
			this.numberOfBedrooms = numberOfBedrooms;
		}
		else {
			throw new IllegalPropertyArgumentException("Numnber of bedrooms must be greater than 0");
		}
	}
	@Override
	public int compareTo(Property objectToCompare) {
		
		return (int) (this.PropertyID - objectToCompare.PropertyID);
	}
	
	
	public String toString() {
		return getClass() + " Property ID: " + PropertyID + " Address: " + address + " Number of Baths: "
	+ numberOfBaths + " Number Of Bedrooms: " +  numberOfBedrooms;
	}

}
