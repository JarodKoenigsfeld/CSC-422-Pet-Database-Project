package petApplication;

import java.util.Scanner;

public class Application {
	private PetDatabase db = new PetDatabase();
	private Input input = new Input();
	private Menu menu = new Menu();
	Scanner scanner = new Scanner(System.in);
	private int cursor = 0;

	//The application runs off this loop.
	public void runApplicationLoop() {
		//While loop terminates if cursor = 7.
		//Even if the menu.exit() fails, it should terminate.
		while (cursor != 7) {
			menu.displayMenuOptions();
			cursor = input.setCursor(scanner);

			switch (cursor) {

			case 0:
				db.debugPopulate();

			case 1:
				//Calls the displayDatabase() method in the database class.
				//It uses the display functions found in the menu class.
				db.displayDatabase(menu);
				continue;

			case 2:
				//Adds a pet to the database.

				//petsAdded keeps track of how many pets were added.
				int petsAdded = 0;
				addPetsToDatabase(db, input, petsAdded);
				continue;

			case 3:
				//Updates a pet
				System.out.println("Not implemented!");
				continue;

			case 4:
				//Searches by name
				db.searchDatabaseByName(input.getNameForSearch(scanner), menu);
				continue;

			case 5:
				//Searches by age
				db.searchDatabaseByAge(input.getAgeForSearch(scanner), menu);
				continue;

			case 6:
				//Deletes a pet
				System.out.println("Not implemented!");
				continue;

			case 7:
				//Exits the program.
				scanner.close();
				exit();

			default:
				//Stops user from typing invalid entries
				invalidOption();
				continue;


			}
		}
	}

	//Method for adding pets to a database.
	//input: A database object that will receive the new pets. An Input object to tokenize the input, and an int to count how many are added.
	public void addPetsToDatabase(PetDatabase databaseToEdit, Input input, int petsToAdd) {
		petsToAdd = 0;
		while (true) {
			System.out.printf("Name the new pet and provide their age, or type 'done' to exit: ");
			//Uses Input's tokenize() method to create tokens out of the next lines.
			input.tokenize(scanner.nextLine());
			if (input.isDone() == true) {
				System.out.println(petsToAdd + " pets were added.");
				return;
			}
			//Uses the addToDatabase function of the database we specify, uses Input's getName and getAge methods.
			databaseToEdit.addToDatabase(input.getInputName(), input.getInputAge());
			petsToAdd++;
		}
	}

	//Used to print an error for invalid option selection.
	public void invalidOption() {
		System.out.println("Invalid Option");
		System.out.println();
	}

	//Prints a message, then ends the program.
	public void exit() {
		System.out.println("Goodbye!");
		System.exit(0);
	}
}