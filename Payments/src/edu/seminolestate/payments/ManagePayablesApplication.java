// Author: Holly Bancroft
// Date: 7/19/2020
// Project name: Payments
// Purpose: An application to manage payables for a business
package edu.seminolestate.payments;

import edu.seminolestate.payable.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.seminolestate.employees.*;
import edu.seminolestate.exceptions.InvalidArgumentException;
import edu.semionlestate.bill.*;

public class ManagePayablesApplication {

	public static void main(String[] args) throws InvalidArgumentException {

		ArrayList<Payable> payableObjects = new ArrayList<Payable>();

		Scanner input = new Scanner(System.in);
		int menuChoice = 0;
		do {

			boolean validInput = false;

			do { // This displays the menu and checks if the user enters an actual value with
					// correct input
				System.out.println(" 1. Add hourly employee\n 2. Add manager\n 3. Add bill\n "
						+ "4. List all payables\n 5. Exit.");

				String line = input.nextLine(); // Storing as a string to ensure user doesn't just hit the enter button

				if (line.length() > 0) {
					try {

						menuChoice = Integer.parseInt(line); // Typecasting to int to check additional criteria

						if (menuChoice <= 0 || menuChoice > 5) {
							System.out.println("You must enter an integar 1-5.");

						} else if (menuChoice > 0 && menuChoice < 6) {
							validInput = true;
						}
					} catch (NumberFormatException e) {
						System.out.println("You must enter an integar number.");
					}
				} else {
					System.out.println("You must enter a value.");
				}
			} while (!validInput);

			if (menuChoice == 1) {
				// Using methods whenever the criteria for the data entered is the same to check
				// if data is valid
				System.out.println("First name for employee ");
				String firstName = checkName();

				System.out.println("Last name for employee ");
				String lastName = checkName();

				int employeeId = checkId();

				System.out.println("Hours worked ");
				double hoursWorked = checkDoubleValue();

				System.out.println("Pay rate ");
				double payRate = checkDoubleValue();

				Employee hourlyEmployee = new HourlyEmployee(firstName, lastName, employeeId, hoursWorked, payRate);

				payableObjects.add(hourlyEmployee);
			}

			else if (menuChoice == 2) {

				System.out.println("First name for employee ");
				String firstName = checkName();

				System.out.println("Last name for employee ");
				String lastName = checkName();

				int employeeId = checkId();

				System.out.println("Annual salary ");
				double annualSalary = checkDoubleValue();

				Employee manager = new Manager(firstName, lastName, employeeId, annualSalary);

				payableObjects.add(manager);
			}

			else if (menuChoice == 3) {

				System.out.println("Vendor na1me ");
				String vendorName = checkName();

				System.out.println("Amount due ");
				double amountDue = checkDoubleValue();

				LocalDate dueDate = null;
				boolean inputOk = false;
				while (!inputOk) {
					System.out.println("Enter the due date (like 7/19/2020): ");
					String newDateinString = input.nextLine();
					if (newDateinString.length() > 0) {

						try {
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
							dueDate = LocalDate.parse(newDateinString, formatter);
							inputOk = true;
						} catch (DateTimeParseException e) {
							System.out.println("Invalid date format.");
							inputOk = false;
						}
					} else {
						System.out.println("You must enter a value");
					}
				}

				Bill newBill = new Bill(vendorName, amountDue, dueDate);

				payableObjects.add(newBill);
			} else if (menuChoice == 4) {
				if (payableObjects.isEmpty()) {
					System.out.println("There are no objects to display");
				} else {
					for (int i = 0; i < payableObjects.size(); i++) {
						System.out.println(payableObjects.get(i).toString());
						System.out.print("Amount to pay: $");
						System.out.println(payableObjects.get(i).computeAmountToPay());
					}
				}
			}

		} while (menuChoice != 5);

		System.out.println("Thank you for using the manage payables application!");
	}

	public static String checkName() {

		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		String name = null;

		while (!validInput) {
			System.out.println("Enter a name: ");
			name = input.nextLine();

			if (name == null || name.length() < 1) {
				System.out.println("Name must have a value");
			} else if (name != null || name.length() > 0) {
				validInput = true;

			}
		}
		return name;
	}

	public static int checkId() {

		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int iD = 0;

		while (!validInput) {
			System.out.println("Enter an employee ID: ");
			String line = input.nextLine();
			if (line.length() > 0) {

				try {

					iD = Integer.parseInt(line);

					if (iD > 0) {

						validInput = true;
					} else {
						System.out.println("ID must be greater than 0.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Enter only integar numbers.");
				}
			} else {
				System.out.println("You must enter a value");
			}
		}

		return iD;
	}

	public static double checkDoubleValue() {

		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		double doubleValue = 0;

		while (!validInput) {
			System.out.print("Enter a value: ");

			String line = input.nextLine();
			if (line.length() > 0) {

			}
			try {
				doubleValue = Double.parseDouble(line);

				if (doubleValue > 0) {
					validInput = true;
				} else {
					System.out.println("Value must be greater than 0");

				}
			} catch (NumberFormatException e) {
				System.out.println("Enter only decimal numbers");
			}

		}

		return doubleValue;
	}

}
