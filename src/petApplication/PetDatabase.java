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
		System.out.println("Deleting "+database[toDelete].getName() + " " + database[toDelete].getAge());
		//Sets the array's index to null.
		database[toDelete] = null;
		
		//Creating a temp array and temp index for the loop we're about to go into.
		Pet[] temp = new Pet[length];
		int tempIndex = 0;
		
		//Loop to condense the database's IDs, so that the empty index isn't in the middle.
		//This loop goes over the entire database, and adds each non-null to a temp array.
		//It then runs the setID() method to conform their ID to the index of the array.
		for(int i = 0; i < database.length; i++) {
			if (database[i] == null) {
				continue;
			}
			temp[tempIndex] = database[i];
			temp[tempIndex].setID(tempIndex);
			tempIndex++;
			
		}
		database = temp;
	}//End of deletePet()


} //End of database methods.