package petApplication;

public class PetDatabase extends Database{
	private int length = 10;
	private int currentID = 0;
	Pet[] database = new Pet[length];

	//Adds a pet to the database.
	public void addToDatabase(String name, int age) {
		if (getFirstAvailableIndex() == -1) {
			System.out.println("Array full!");
		} else {
			Pet newPet = new Pet(currentID, name, age);
			currentID++;
			database[getFirstAvailableIndex()] = newPet;
		}
	} //end of addPet();

	//Debug command to fill the table with generic Pets.
	public void debugPopulate() {

		for (int i = 0; i < database.length; i++) {

			if(database[i]== null) {

				database[i] = new Pet(i, "Test"+i, i%2);
			}
		}
	} //end of debugPopulate();

	//Gets first available index.
	public int getFirstAvailableIndex() {
		for (int i = 0; i < database.length; i++) {
			if (database[i] == null) {
				return i;
			}
		}
		//Return -1 if array is full.
		return -1;
	}

	//Display the database, using the display functions found in the menu class.
	public void displayDatabase(Menu menu) {
		menu.printHeader();
		int rows = 0;
		for (int i = 0; i < database.length; i++) {
			//database[i] = new Pet(i, "Test", 5);
			if (database[i] == null) {
				continue;
			}
			//Since our database is full of objects, we can call their methods to get the data we need.
			menu.printRow(database[i].getID(), database[i].getName(), database[i].getAge());
			rows++;
		}
		menu.printFooter(rows);
	} //end of DisplayDatabase();
	
	public void searchDatabaseByName(String nameForSearch, Menu menu) {
		int found = 0;
		menu.printHeader();
		for (int i = 0; i < database.length; i++) {
			if (database[i] == null) {
				continue;
			}
			//This converts nameForSearch into lowercase characters, then it converts the name of the Pet at position i in the database into lowercase characters.
			//If they match, it prints the row.
			//In pseudocode, "if name.lower() == database[i].lower(), then printrow(database[i])"
			if (nameForSearch.toLowerCase().equals(database[i].getName().toLowerCase()) == true) {
				menu.printRow(database[i].getID(), database[i].getName(), database[i].getAge());
				found++;
			}
		}
		if (found == 0) {
			menu.printInvalidRow();
		}
		menu.printFooter(found);
	} //End of searchDatabaseByName()
	
	//Takes an int, and loops through the database. Each Pet object has the getAge() method called for checking.
	//Each time it finds a pet with a matching age, it increments a variable "Found" by 1.
	//If no pets are found, it has a special printout to show the database failed to find a match.
	public void searchDatabaseByAge(int ageForSearch, Menu menu) {
		int found = 0;
		menu.printHeader();
		for (int i = 0; i < database.length; i++) {
			if (database[i] == null) {
				continue;
			}
			if (database[i].getAge() == ageForSearch) {
				menu.printRow(database[i].getID(), database[i].getName(), database[i].getAge());
				found++;
			}
		}
		if (found == 0) {
			menu.printInvalidRow();
		}
		menu.printFooter(found);
	} //End of searchDatabaseByAge();

	public void updateEntry(int indexForSearch, String newName, int newAge) {
		database[indexForSearch].setAge(newAge);
		database[indexForSearch].setName(newName);
	}//End of updatePet()

	public void deleteEntry(int toDelete) {
		//Sets the array's index to null.
		database[toDelete] = null;
		//Loop to condense the database's IDs, so that the empty index isn't in the middle.
		for(int i = toDelete+1; i < database.length; i++) {
			database[i-1] = database[i];
			database[i].setID(i-1);
		}
		//After condensing the database down, this last entry will always be a duplicate.
		//So we can delete it.
		database[database.length-1] = null;
	}//End of deletePet()


} //End of database methods.