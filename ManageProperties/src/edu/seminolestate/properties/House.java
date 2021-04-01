//Holly Bancroft
// 8/1/2020
package edu.seminolestate.properties;

public class House extends Property {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double lotSize;
	private double value;
	
	public House(int newPropertyID, String newAddress, double newNumberOfBaths, int newNumberOfBedrooms,
			double newLotSize, double newValue) throws IllegalPropertyArgumentException {
		
		super(newPropertyID, newAddress, newNumberOfBaths, newNumberOfBedrooms);
		
		this.setLotSize(newLotSize);
		this.setValue(newValue);
	}

	public double getLotSize() {
		return lotSize;
	}

	public void setLotSize(double lotSize) throws IllegalPropertyArgumentException {
		if(lotSize > 0) {
			this.lotSize = lotSize;
		}
		else {
			throw new IllegalPropertyArgumentException("Lot size must be greater than 0");
		}
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) throws IllegalPropertyArgumentException{
		if(value > 0) {
			this.value = value;
		}
		else {
			throw new IllegalPropertyArgumentException("Value must be greater than 0");
		}
	}
	
	public String toString() {
		return getClass() + super.toString() + " Lot Size: " + lotSize + " Value: " + value;
	}
	
}
