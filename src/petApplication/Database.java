package petApplication;

public abstract class Database {
	int length;
	int currentID;
	Object[] database;

	abstract public void addToDatabase(String name, int age);
	abstract public void displayDatabase(Menu menu);
	abstract public void updateEntry(int index, String newName, int newAge);
	abstract public void deleteEntry(int index);
}
