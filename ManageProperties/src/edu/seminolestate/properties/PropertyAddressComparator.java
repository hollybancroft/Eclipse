//Holly Bancroft
// 8/1/2020
package edu.seminolestate.properties;

import java.util.Comparator;

public class PropertyAddressComparator implements Comparator<Property> {

	@Override
	public int compare(Property p1, Property p2) {
		int addressCompare =  p1.getAddress().compareTo(p2.getAddress());
		return addressCompare;
	}
}