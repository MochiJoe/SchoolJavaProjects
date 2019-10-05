

/*
 * Nolaundron 'Ray' Harris
 * CSC 142 
 * Project 3 ISBN Identifier
 * 
 */

import java.util.Scanner;

public class ISBN {

	public static void main(String[] args) {
		boolean done = false;
		description();
		Scanner console = new Scanner(System.in);
		while (!done) {
			displayMenu();// this was commented
			String selection = getUsersSelection(console);
			done = processSelection(selection, console);

		}
	}

	public static void description() {
		System.out.println(
		"This program will vaildate your entered ISBN # \n" 
		+ "and tell you rather it is valid or not.\n");
	}

	public static void displayMenu() {
		System.out.println("Enter one these options:");
		System.out.println("\tH for Help");
		System.out.println("\tU for using ISBN Identifier");
		System.out.println("\tQ for exiting this program");
		System.out.print("What would you like to do?: ");
	}

	private static String getUsersSelection(Scanner console) {
		String selection = console.next();
		return selection;
	}

	private static boolean processSelection(String selection, Scanner console) {
		boolean done = false;

		if (!selection.equalsIgnoreCase("Q")) {
			if (selection.equalsIgnoreCase("U")) {
				checkISBN(console); //

			} else if (selection.equalsIgnoreCase("H")) {
				// nothing to do here...let the code loop around one more time
			} else {
				System.out.println("Incorrect entry...try again!");
			}
		} else {
			done = true;
		}
		return done;
	}

	public static void checkISBN(Scanner console) {
		displayISBNInstruction();
		String isbnNum = console.next();
		String noDashISBN = isbnNum.replaceAll("-", "");
		int total = 0;
		int numCount = 0;
		int remainder = 0;
		int checkSum = 0;
		int dashCount = 0;
		
		char x = 'X';

		if (Character.valueOf(isbnNum.charAt(0)).equals('-')
				|| Character.valueOf(isbnNum.charAt(isbnNum.length() - 1)).equals('-')) {
			incorrectISBN(isbnNum, 1);// says the ISBN is not valid(start or ends with dash)
		} else if (isbnNum.contains("--")) {
			incorrectISBN(isbnNum, 2);// says the ISBN is not valid(has "--")
		} else if (noDashISBN.length() != 10) {
			incorrectISBN(isbnNum, 3);// says the ISBN is not valid(does not have 10 digits)
		} else if (isbnNum.length() - noDashISBN.length() != 0 &&
				isbnNum.length() - noDashISBN.length() != 3) {
			incorrectISBN(isbnNum, 4);//invalid(too many or not enough dashes)
		} else {

			// the max for the ISBN count is 12(11 if start @ 0)
			for (int i = 0; i <= isbnNum.length() - 2; i++) {

				if (Character.isDigit(isbnNum.charAt(i))) {
					numCount++;
					int digit = Character.getNumericValue(isbnNum.charAt(i));
					total = total + (digit * (numCount));

					// The following print statement was a test to make sure
					// all numbers were working.
					// System.out.printf("Digit %d x numCount %d%n", digit, numCount);
				//} else if (isbnNum.charAt(i) == '-') {
				//	dashCount++;
					
				//	}
				}
			
				

			}
			remainder = total % 11;

			// System.out.println(remainder);

			// Last character number
			if (Character.toLowerCase(isbnNum.charAt(isbnNum.length() - 1)) == 'x') {
				checkSum = 10;
			} else {
				checkSum = Character.getNumericValue(isbnNum.charAt(isbnNum.length() - 1));
			}

			// Is it true?
			if (remainder == checkSum) {
				correctISBN(isbnNum);
			} else {

				incorrectISBN(isbnNum, 5);// final number does not match
			}
		}
	}

	private static void incorrectISBN(String isbnNum, int errorMsg) {
		if (errorMsg == 1) {
			System.out.printf("The ISBN number, %s, is invalid! (Your ISBN number starts and or ends with dash.) %n %n", isbnNum);
		} else if (errorMsg == 2) {
			System.out.printf("The ISBN number, %s, is invalid! (Your ISBN number contains \"--\" - a double dash.) %n %n", isbnNum);
		} else if (errorMsg == 3) {
			System.out.printf("The ISBN number, %s, is invalid! (Your ISBN number does not have 10 digits (more or less)) %n %n", isbnNum);
		} else if (errorMsg == 4) {
			System.out.printf("The ISBN number, %s, is invalid! (Your ISBN number has too many or not enough dashes) %n %n", isbnNum);
		} else if (errorMsg == 5) {
			System.out.printf("The ISBN number, %s, is invalid! (Your ISBN number has a bad digit) %n %n", isbnNum);
		}
		
	}

	private static void correctISBN(String isbnNum) {
		System.out.printf("The ISBN number, %s, is valid. %n %n", isbnNum);
	}

	public static void displayISBNInstruction() {
		System.out.println("Enter a ten digit ISBN number");
		System.out.println("You may enter your ISBN number with dashes as follows:");
		System.out.println("xxxxxxxxxx");
		System.out.println("x-xx-xxxxxx-x");
		System.out.println("x-xxx-xxxxx-x");
		System.out.print("ISBN number: ");
	}

}
