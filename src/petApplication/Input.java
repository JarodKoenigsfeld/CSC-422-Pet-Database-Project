package petApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	private String[] tokens;

	public void tokenize(String input) {
		tokens = input.split("\\s+");
	}

	public String getInputName() {
		return tokens[0];
	}

	public int getInputAge() {
		return Integer.parseInt(tokens[1]);
	}

	//helper method to detect when the user has typed "done".
	public boolean isDone() {
		return this.getInputName().toLowerCase().equals("done");
	}
	
	public int getAgeForSearch(Scanner scanner) {
		System.out.println("What age would you like to search for? ");
		return Integer.parseInt(scanner.nextLine());
	}

	public String getNameForSearch(Scanner scanner) {
		System.out.println("What name would you like to search for?");
		return scanner.nextLine();
	}

	public int getIDForSearch(Scanner scanner) {
		System.out.println("What is the ID you would like to search for?");
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