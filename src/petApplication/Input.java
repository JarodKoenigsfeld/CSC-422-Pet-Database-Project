package petApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	private String[] tokens;
	
	//Splits a string into tokens, dividing them along any spaces.
	public void tokenize(String input) {
		tokens = input.split("\\s+");
	}

	//Returns the 0th token, for this program that is always going to be a name.
	public String getInputName() {
		return tokens[0];
	}

	//returns the 1st token, for this program that is always going to be an age.
	public int getInputAge() {
		return Integer.parseInt(tokens[1]);
	}

	//helper method to detect when the user has typed "done".
	public boolean isDone() {
		return this.getInputName().toLowerCase().equals("done");
	}
	
	//Helper method to print a specific message when searching by age.
	public int getAgeForSearch(Scanner scanner) {
		System.out.println("What age would you like to search for? ");
		return Integer.parseInt(scanner.nextLine());
	}
	
	//Helper method to print a specific message when searching by name.
	public String getNameForSearch(Scanner scanner) {
		System.out.println("What name would you like to search for?");
		return scanner.nextLine();
	}

	//Returns an int based on the user's input.
	public int getIDForSearch(Scanner scanner) {
		return Integer.parseInt(scanner.nextLine());
	}

	//Not a literal cursor! Just tells the application which choice the user selects, like a cursor clicks on an icon.
	public int setCursor(Scanner scanner) {
		int cursor = 0;
		//The user types a number to make their choice.
		try {
			cursor = scanner.nextInt();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Input mismatch");
			System.out.println();
			scanner.nextLine();
		}
		return cursor;
	}

	Input(String inputString){
		this.tokenize(inputString);
	}

	Input(){
	}
}