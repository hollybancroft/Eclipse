// Author: Holly Bancroft
// Date: 8/1/2020
// Program Name: ManageProperties
// Purpose: An application to help manage real estate properties and store the data in a file
package edu.seminolestate.manageproperties;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import edu.seminolestate.properties.Apartment;
import edu.seminolestate.properties.House;
import edu.seminolestate.properties.IllegalPropertyArgumentException;
import edu.seminolestate.properties.Property;
import edu.seminolestate.properties.PropertyAddressComparator;

public class ManageProperties {

	private static final String FILE_NAME = "properties.dat";

	public static void main(String[] args) throws IllegalPropertyArgumentException {

		File outputFile = new File(FILE_NAME);
		File inputFile = new File(FILE_NAME);

		ArrayList<Property> propertyObjects = new ArrayList<Property>();

		if (inputFile.exists()) { // Check if file exists, and if it does, copy the existing objects into the
									// array list
			int numberOfPropertiesRead = 0;
			try (FileInputStream fiStream = new FileInputStream(inputFile);
					ObjectInputStream oiStream = new ObjectInputStream(fiStream);) {
				while (true) {
					Property property = (Property) oiStream.readObject();
					propertyObjects.add(property);
					numberOfPropertiesRead++;
				}

			} catch (EOFException e) {
				System.out.println("Done processing " + numberOfPropertiesRead + " properties"); // This will show how
																									// many objects were
																									// already in the
																									// file
			} catch (IOException e) {
				System.out.println("Shutting down");
				e.printStackTrace();
				System.exit(-1);
			} catch (ClassNotFoundException e) {
				System.out.println("Serialization version error.");
				e.printStackTrace();
				System.exit(-1);
			}
		}

		Scanner input = new Scanner(System.in);

		int menuChoice = 0;

		boolean arrayListEmpty = true;

		do { // Begin application by displaying menu and checking the input criteria

			boolean validInput = false;

			do {

				System.out.println(" 1. Add house\n 2. Add apartment\n 3. List all properties by ID\n "
						+ "4. List all properties by address\n 5. Exit");

				String line = input.nextLine(); // Storing as a string to ensure user doesn't just hit the enter button

				if (line.length() > 0) {
					try {

						menuChoice = Integer.parseInt(line); // Typecasting to int to check additional criteria

						if (menuChoice <= 0 || menuChoice > 5) {
							System.out.println("You must enter an integer 1-5.");

						} else if (menuChoice > 0 && menuChoice < 6) {
							validInput = true;
						}
					} catch (NumberFormatException e) {
						System.out.println("You must enter an integer number.");
					}
				} else {
					System.out.println("You must enter a value.");
				}

			} while (!validInput);

			if (menuChoice == 1) {

				System.out.println("Property ID "); // Using methods to check input to meet project criteria
				int propertyID = (int) checkNumericValue();

				System.out.println("Property address ");
				String address = checkStringValue();

				System.out.println("Number of baths ");
				double numberOfBaths = checkNumericValue();

				System.out.println("Number of bedrooms ");
				int numberOfBedrooms = (int) checkNumericValue();

				System.out.println("Lot size ");
				double lotSize = checkNumericValue();

				System.out.println("House value ");
				double houseValue = checkNumericValue();

				Property house = new House(propertyID, address, numberOfBaths, numberOfBedrooms, lotSize, houseValue);

				propertyObjects.add(house);

				arrayListEmpty = false;

			}

			else if (menuChoice == 2) {

				System.out.println("Property ID ");
				int propertyID = (int) checkNumericValue();

				System.out.println("Property address ");
				String address = checkStringValue();

				System.out.println("Number of baths ");
				double numberOfBaths = checkNumericValue();

				System.out.println("Number of bedrooms ");
				int numberOfBedrooms = (int) checkNumericValue();

				System.out.println("Unit rent ");
				double unitRent = checkNumericValue();

				Property apartment = new Apartment(propertyID, address, numberOfBaths, numberOfBedrooms, unitRent);

				propertyObjects.add(apartment);

				arrayListEmpty = false;

			} else if (menuChoice == 3) {
				Collections.sort(propertyObjects);
				for (Property property : propertyObjects) {
					System.out.println(property);
				}

			} else if (menuChoice == 4) {
				PropertyAddressComparator c = new PropertyAddressComparator();
				Collections.sort(propertyObjects, c);
				for (Property property : propertyObjects) {
					System.out.println(property);
				}
			} else if (menuChoice == 5) {
				if (!arrayListEmpty) {
					try (FileOutputStream foStream = new FileOutputStream(outputFile);
							ObjectOutputStream ooStream = new ObjectOutputStream(foStream);) {
						for (int i = 0; i < propertyObjects.size(); i++) {
							ooStream.writeObject(propertyObjects.get(i));
						}
					} catch (FileNotFoundException e) {
						System.out.println("Is file name and location correct?");
						e.printStackTrace();
						System.exit(-1);
					} catch (IOException e) {
						System.out.println("Shutting down");
						e.printStackTrace();
						System.exit(-1);
					}
				}
			}

		} while (menuChoice != 5);

		System.out.println("Thank you for using the Property Manager!");

	}

	public static double checkNumericValue() {

		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		double value = 0;
		while (!validInput) {

			System.out.println("Enter a value: ");

			value = input.nextDouble();
			if (value > 0) {
				validInput = true;
			} else {
				System.out.println("Value must be greater than 0");
			}
		}
		return value;
	}

	public static String checkStringValue() {

		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		String value = null;

		while (!validInput) {
			System.out.println("Enter a value: ");
			value = input.nextLine();

			if (value != null || value.length() > 0) {
				validInput = true;
			} else {
				System.out.println("Value must not be null or have a length less than 1");
			}
		}
		return value;
	}
}