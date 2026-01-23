package petApplication;

public class Pet extends Animal{

	private int ID;
	private String name;
	private int age;

	int maxAge = 20;
	int maxID = 999;
	int maxNameLength = 10;

	//Returns the pet's name.
	public String getName() {
		//System.out.println(name);
		return name;
	}

	//Returns the pet's age.
	public int getAge() {
		//System.out.println(age);
		return age;
	}

	//Returns the pet's ID.
	public int getID() {
		//System.out.println(ID);
		return ID;
	}

	//Sets the pet's name.
	public void setName(String newName) {
		this.name = newName;
		//In case a string is too long.
		if(newName.length() > maxNameLength) {
			this.name = newName.substring(0, maxNameLength);
			System.out.println("Error: Name was too long! It has been trimmed to " + name);
		}
	}

	//Sets the pet's ID.
	public void setID(int newID) {
		this.ID = newID;
		if(newID > maxID) {
			this.ID = maxID;
		}
	}

	//Sets the pet's age.
	public void setAge(int newAge) {
		this.age = newAge;
		if(newAge > maxAge) {
			this.age = maxAge;
			System.out.println("Error: Age was too high! It has been clamped to " + age);
		}
	}

	//Constructor for a pet object will all variables defined.
	public Pet(int inputID, String inputName, int inputAge) {
		this.ID = inputID;
		this.name = inputName;
		this.age = inputAge;
		//If the ID is too high, set it to the max.
		if(inputID > maxID) {
			inputID = maxID;
		}

		//In case a string is too long.
		if(inputName.length() > maxNameLength) {
			this.name = inputName.substring(0, maxNameLength);
		}

		//Prevents age from going above 4 digits.
		if(inputAge > maxAge) {
			this.age = maxAge;
		}
	}

	//Overloaded constructor in case an age is missing
	//Sets age to 0.
	public Pet(int inputID, String inputName) {
		this.ID = inputID;
		this.name = inputName;
		this.age = 0;
	}

	//Overloaded constructor in case a name and age are missing
	//Sets age to 0 and adds NO_NAME_SET as the name
	public Pet(int inputID) {
		this.ID = inputID;
		this.name = "NO_NAME_SET";
		this.age = 0;
	}

}