package program4;

import java.io.*;
import java.util.*;

/**
 * This program displays data of an employee stored in the
 * EmployeeData.dat file.
 * @author Hannah Ingham
 * Date: 4/27/2023
 *
 */
public class DisplayData {

	public static void main(String[] args) {
		
		final int EMPLOYEE_SIZE = 54;	//The number of bytes that an employee's
										//data will be
		final int NUMBER_OFFSET = 34;   //The employee number is offset 34 bytes 
		final int SHIFT_OFFSET = 42; 	//The employee's shift is offset 42 bytes
		final int PAY_OFFSET = 46; 		//The employee's pay is offset 46 bytes
		long byteNum; 	//The number byte to read
		int empNum; 	//The number employee's data to read
		String answer; 	//Whether or not the user wants to read more data 
		
		System.out.println("This program displays " +
				"information for an employee in " +
				"EmployeeData.dat");
		
		//Create a Scanner object to read input from the user.
		Scanner keyboard = new Scanner(System.in);
		
		//Open the file for reading.
		try {
			RandomAccessFile myFile = new RandomAccessFile("EmployeeData.dat", "r");
			
			do { 
				System.out.print("\nWhich employee would you like to read the " +
						"data of? (1-10): ");
			
				try {
					//Navigate to the correct byte number.
					empNum = keyboard.nextInt() - 1;
					byteNum = EMPLOYEE_SIZE * empNum;
					myFile.seek(byteNum);
					String name = myFile.readUTF();
						
					//Display the name for that employee.
					System.out.println("\nName: " + name.trim());
						
					//Navigate to the employee number and display it.
					myFile.seek(byteNum + NUMBER_OFFSET);
					String number = myFile.readUTF();
					System.out.println("Number: " + number);
						
					//Navigate to the employee's shift and display it.
					myFile.seek(byteNum + SHIFT_OFFSET);
					int shift = myFile.readInt();
					System.out.println("Shift: " + shift);
						
					//Navigate to the employee's pay and display it.
					myFile.seek(byteNum + PAY_OFFSET);
					double pay = myFile.readDouble();
					System.out.printf("Pay: $%,.2f\n\n", pay);
				}
				catch (IOException e) {
					System.out.println("Error : " + e.getMessage());
				}
				catch (InputMismatchException e) {
					System.out.println("Please enter a valid number.");
				}
				finally {
					keyboard.nextLine();
				}
				
				//Ask the user if they want to read more data.
				System.out.print("Would you like to read more data? [Y/n]: ");
				answer = keyboard.nextLine();
				
			} while (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase(""));
			
			//Close the file.
			myFile.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("The file does not exist.");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		//Close the scanner.
		keyboard.close();
	}
}
