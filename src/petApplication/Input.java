package petApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	private String[] tokens;

	public void tokenize(String input) {
		tokens = input.split("\\s+");
	}

	public String getName() {
		return tokens[0];
	}

	public int getAge() {
		return Integer.parseInt(tokens[1]);
	}

	public boolean isDone() {
		return this.getName().toLowerCase().equals("done");
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