package program4;

import java.io.*;
import java.util.*;

/**
 * This program uses a RandomAccessFile object to create the file 
 * EmployeeData.dat and writes the information for ten employees
 * to it according to the user's input. 
 * @author Hannah Ingham
 * Date: 4/27/2023
 */
public class EmployeeData {

	public static void main(String[] args) {
		
		System.out.println("This program creates a new file that" +
				" stores data for ten employees.");
		
		//Create a scanner object to read keyboard input.
		Scanner keyboard = new Scanner(System.in);
		
		try {
			//Open a file for reading and writing.
			RandomAccessFile employeeData = new RandomAccessFile(
				"EmployeeData.dat", "rw");
		
			//Get the user's input for each employee and write it to the file.
			for (int i = 1; i <= 10; i++) {
				String name; 
				String number;
				int shift = 0;
				double pay = 0.0;
				boolean error = false;

				//Get the name of the employee.
				System.out.print("\nPlease enter the name of employee " +
								i + ": ");
				name = keyboard.nextLine();
						
				//Truncate the String or pad it with spaces if it is not 
				//32 characters long.
				if (name.length() > 32) 
					name = name.substring(0, 32);
				else if (name.length() < 32 ) {
					while (name.length() < 32) {
						name = name + " ";
					}
				}
			
				do {
					error = false;
					
					//Get the employee's number.
					System.out.print("Please enter the number of employee " +
							i + " (6 numbers long): ");
					number = keyboard.nextLine();
					
					//Validate the input.
					if (!(number.length() == 6)) {
						error = true;
					}
				} while (error);
			
				do {
					error = false;
					
					try {
						//Get the employee's shift.
						System.out.print("Please enter the shift of employee " + 
								i + " (1, 2, or 3): ");
						shift = keyboard.nextInt();
								
						//Validate the input.
						if (!(shift >= 1 && shift <= 3)) {
							error = true;
						}
					}
					catch (InputMismatchException e) {
						error = true;
					}
				} while (error);
			
				do {
					error = false;
					
					try {
						//Get the employee's pay rate.
						System.out.print("Please enter the pay rate of employee " +
								i + " (A positive number): $");
						pay = keyboard.nextDouble();
						
						//Validate the input.
						if (pay < 0) {
							error = true;
						}
					}
					catch (InputMismatchException e) {
						error = true;
					}
				} while (error);
			
				try {
					//Write the information to the file.
					employeeData.writeUTF(name);
					employeeData.writeUTF(number);
					employeeData.writeInt(shift);
					employeeData.writeDouble(pay);
				}
				catch (IOException e) {
					System.out.println("Error: " + e.getMessage());
				}
				//Skip past the newline.
				keyboard.nextLine();
			}
		
			//Close the file.
			employeeData.close(); 
		}
		catch (FileNotFoundException e) {
			System.out.println("The file cannot be located.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("The file has been created.");
		
		//Close the Scanner.
		keyboard.close();
	}
}