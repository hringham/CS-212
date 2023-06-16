package program4;

import java.io.*;
import java.util.*;

/**
 * This program updates information of employees
 * from the EmployeeData.dat file.
 * @author Hannah Ingham
 * Date: 4/27/2023
 */
public class UpdateData {

	public static void main(String[] args) {
		
		final int EMPLOYEE_SIZE = 54;	//The total number of bytes that an employee's
										//data will be
		final int NUMBER_OFFSET = 34;   //The employee number is offset 34 bytes 
		final int SHIFT_OFFSET = 42; 	//The employee's shift is offset 42 bytes
		final int PAY_OFFSET = 46; 		//The employee's pay is offset 46 bytes
		String name; 
		String number;
		int shift = 0;
		double pay = 0.0;
		boolean error = false; //A flag to indicate there is an error
		long byteNum; 	//The number byte to read
		int empNum; 	//The number employee's data to read
		String answer; //Whether or not the user wants to read more data

		System.out.println("This program opens EmployeeData.dat and" +
				" updates data for a specific employee.");
		
		//Create a scanner object to read keyboard input.
		Scanner keyboard = new Scanner(System.in);
		
		do {
			System.out.print("\nWhich employee would you like to " +
					"change information for? (1-10): ");
			
			try {	
				empNum = keyboard.nextInt();
				
				if (empNum >= 1 && empNum <= 10) {
					//Open a file for reading and writing.
					RandomAccessFile file = new RandomAccessFile(
							"EmployeeData.dat", "rw");
						
					//Navigate to the start of that employee's data.
					byteNum = EMPLOYEE_SIZE * (empNum - 1);
					file.seek(byteNum);
				
					//Update the name of the employee.
					System.out.print("\nPlease enter the name of employee " +
									empNum + ": ");
					keyboard.nextLine();
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
					file.writeUTF(name);
						
					//Update the employee's number.
					file.seek(byteNum + NUMBER_OFFSET);
					do {
						error = false;
									
						//Get the employee's number.
						System.out.print("Please enter the number of employee " +
								empNum + " (6 characters long): ");
						number = keyboard.nextLine();
									
						//Validate the input.
						if (!(number.length() == 6)) {
							error = true;
						}
					} while (error);
					file.writeUTF(number);
							
					//Update the employee's shift. 
					file.seek(byteNum + SHIFT_OFFSET);
					do {
						error = false;
							
						try {
							//Get the employee's shift.
							System.out.print("Please enter the shift of employee " + 
									empNum + " (1, 2, or 3): ");
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
					file.writeInt(shift);
							
					//Update the employee's pay.
					file.seek(byteNum + PAY_OFFSET);
					do {
						error = false;
							
						try {
							//Get the employee's pay rate.
							System.out.print("Please enter the pay rate of employee " +
									empNum + " (A positive number): ");
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
					file.writeDouble(pay);
						
					System.out.println("The data has been updated.");
						
					//Close the file.
					file.close();
				}
				else {
					error = true;
					System.out.println("Please enter a number 1-10.");
				}
			} 
			catch (FileNotFoundException e) {
				System.out.println("The file could not be located.");
			}
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid number 1-10.");
			}
			finally {
				keyboard.nextLine();
			}
			
			System.out.print("\nWould you like to update more data? [Y/n]: ");
			answer = keyboard.nextLine();
			
		} while ((answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("")) || error);
		
		//Close the Scanner.
		keyboard.close();
	}
}