//Holly Bancroft
// 8/1/2020
package edu.seminolestate.properties;

public class Apartment extends Property{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double unitRent;
	
	public Apartment(int newPropertyID, String newAddress, double newNumberOfBaths, 
			int newNumberOfBedrooms, double newUnitRent ) throws IllegalPropertyArgumentException {
		
		super(newPropertyID, newAddress, newNumberOfBaths, newNumberOfBedrooms);
		
		this.setUnitRent(newUnitRent);
	}

	public double getUnitRent() {
		return unitRent;
	}

	public void setUnitRent(double unitRent) throws IllegalPropertyArgumentException {
		if(unitRent > 0) {
			this.unitRent = unitRent;
		}
		else {
			throw new IllegalPropertyArgumentException("Unit rent must be greater than 0");
		}
		
		}
	
	public String toString() {
		return getClass() + super.toString() + " Unit Rent: " + unitRent;
	}
	
}
