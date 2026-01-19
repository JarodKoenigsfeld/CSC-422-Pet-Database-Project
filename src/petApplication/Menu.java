package petApplication;

public class Menu {

	int cursor = 0;

	//Displays the menu options.
	public void displayMenuOptions() {
		System.out.println("--- Main Menu ---");
		System.out.println("Please choose an option:");
		System.out.println("1. Display Table");
		System.out.println("2. Add Pet");
		System.out.println("3. Edit a Pet (TBD)");
		System.out.println("4. Search by Name");
		System.out.println("5. Search by Age");
		System.out.println("6. Delete a Pet (TBD)");
		System.out.println("7. Exit");
		System.out.print("Your choice: ");
	}

	//Prints a line for the table.
	public void printDivider() {
		System.out.println("+------+---------------------------+------+");
	}

	public void printHeader() {
		System.out.println();
		printDivider();
		System.out.printf("|%-5s | %-25s | %-5s|%n", "ID", "Name", "Age");
		printDivider();
	} //end of printHeader()

	public void printRow(int ID, String name, int age) {
		System.out.printf("|%-5d | %-25s | %-5d|%n", ID, name, age);
	} //end of printRow();

	public void printFooter(int rows) {
		printDivider();
		System.out.println(rows + " rows in set.");
		System.out.println();
	}

	public void printInvalidRow() {
		System.out.printf("|%-5s | %-25s | %-5s|%n", "N/A", "N/A", "N/A");
	}

}