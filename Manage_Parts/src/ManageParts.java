// Author: Holly Bancroft
// Project: Manage_Parts
// Date: 6/20/2020
// Purpose: An application that manages manufactured parts for a business

import java.util.ArrayList;
import java.util.Scanner;
public class ManageParts {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Creating the ArrayList
		ArrayList<Part> partsList = new ArrayList<Part>();
		//Initializing some variables. MenuChoice represents what the user chooses on the menu. ArrayListEmpty will trigger an error if user chooses menu option 3 or 4 before 1 or 2
		int menuChoice = 0;
		boolean arrayListEmpty = true;
		do { 
			System.out.println(" 1. Create Purchased Part\n 2. Create Manufactured Part\n "
					+ "3. List a part\n 4. List all parts\n 5. Exit");
			menuChoice = input.nextInt();
			
			if(menuChoice == 1) {
				System.out.println("Enter a part ID: ");
				int partId = input.nextInt();
				for(int i = 0; i < partsList.size(); i++) {     // This for-loop iterates over the ArrayList to see if the partID has already been used
					if(partsList.get(i).getPartID() == partId) {
				
					System.out.println("This part ID already exists. Please re-enter part ID: ");
					partId=input.nextInt();
					i =0; // i is set back to 0 so the entire list with be iterated through again
					
						}
					}
				input.nextLine();
				System.out.println("Enter a description: ");
				String desc = input.nextLine();
				System.out.println("Enter a sell price: ");
				double sellPrice = input.nextDouble();
				System.out.println("Enter the purchase price: ");
				double purchPrice = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the vendor: ");
				String vendor = input.nextLine();
				System.out.println("Enter the handling cost: ");
				double handCost = input.nextDouble();
				
				Part usersPurchasedPart = new PurchasedPart(partId, desc, sellPrice, handCost, purchPrice, vendor);
				
				partsList.add(usersPurchasedPart);
				
				arrayListEmpty = false;
				
			}
			else if(menuChoice == 2) {
				System.out.println("Enter a part ID: ");
				int partId = input.nextInt();
					for(int i = 0; i < partsList.size(); i++) {
					if(partsList.get(i).getPartID() == partId) {
				
					System.out.println("This part ID already exists. Please re-enter part ID: ");
					partId=input.nextInt();
					i = 0;
						}
					}
				
				input.nextLine();
				System.out.println("Enter a description: ");
				String desc = input.nextLine();
				System.out.println("Enter a sell price: ");
				double sellPrice = input.nextDouble();
				System.out.println("Enter the labor cost: ");
				double laborCost = input.nextDouble();
				System.out.println("Enter the material cost: ");
				double materialCost = input.nextDouble();
				
				Part usersManufacturedPart = new ManufacturedPart(partId, desc, sellPrice, laborCost, materialCost);
				
				partsList.add(usersManufacturedPart);
				
				arrayListEmpty = false;
				
			}
			else if(menuChoice == 3) {
				
				System.out.println("Enter the part ID ");
				int partId = input.nextInt();
				if(arrayListEmpty) { // this code will run if an object has not yet been created
					System.out.println(partId + " was not found");
		
				}
				int foundMatch = 0;
				for(int i = 0; i <partsList.size(); i++) {
				if(partsList.get(i).getPartID() == partId) {
					System.out.println(partsList.get(i).toString());
					System.out.println(partsList.get(i).getTotalCost());
					foundMatch = 1;
					}
				}
				if(foundMatch == 0) {
					System.out.println("This part ID does not exist.");
				}
							
				
			}
			else if(menuChoice == 4) {
				if(arrayListEmpty) {
					System.out.println("There are no parts to list");
				}
				
				for(int i = 0; i<partsList.size(); i++) {
					System.out.println(partsList.get(i).toString());
				System.out.println(partsList.get(i).getTotalCost());
				}
			
			
		}
			else if(menuChoice==5) {
				
			}
			else {
				System.out.println("This is not a valid value. Please re-enter a value 1- 5.");
			}
		}while(menuChoice != 5);
		
		System.out.println("Thanks for using the parts manager!");		
		
		input.close();

	
	}
}
