# CSC-422-Assignment
Week 1 Assignment for CSC-422, Software Engineering.

# Design notes:
The program is composed of 6 classes:  
  
**Pet** - Pet objects have a name, age, and ID.  
**PetDatabase** - Creates an array to store Pet objects, and has the logic needed to add, update, and remove entries.  
**Input** - Handles user input, chiefly the user selecting options and doing data entry.  
**Menu** - Handles displaying user data, including headers and footers.  
**Application** - Combines all of these other classes into a usable application.  
**Main** - Creates and runs an instance of the application.  

To better demonstrate object-oriented design, the classes Pet and PetDatabase extend abstract classes. These classes are Animal and Database, respectively. This means the program could, in the future, be expanded to accommodate different databases with different functionality. For example, a livestock system or zoo management.

# To run on Windows via command line:
This assumes you have already installed and setup Java on your computer. If you have not, please do so.
Navigate to src/petApplication. You will see three files: database.java, pet.java, and main.java.
Right click there, and this will bring up a context menu. Click "Open in Terminal".

Then, type this command: 
```java Main.java```
(It's case sensitive!)

The program should compile and run automatically from there.

Alternatively, you could import this into a Java IDE such as NetBeans, Eclipse, or IntelliJ and run it from there.

# How to Use This Program:

Type 1 to view all pets in the database.

Type 2 to add pets. You'll be prompted to provide the pet's name and age on a single line. Type "done" to stop adding pets. Pet names have maximum length of **ten** characters, and a maximum age of **9999*.

Type 7 to exit.
