package petApplication;

public abstract class Animal {
	int ID;
	String name;
	int age;
	
	int maxID;
	int maxAge;
	int maxNameLength;
	
	abstract String getName();
	abstract int getAge();
	abstract int getID();
	
	abstract public void setName(String newName);
	abstract public void setAge(int newAge);
	abstract public void setID(int newID);

}
