package petApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
	public void openOrCreateFile(String filePath, String fileName) {
		File myFile = new File(filePath+"/"+fileName+".txt");
		try {
			if (myFile.createNewFile()) {
				System.out.println("File "+fileName+" was created!");
			} else {
				System.out.println("File "+fileName+" was found!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void openDatabaseFromFile(String filePath, String fileName, PetDatabase db, Input input) {
		File myFile = new File(filePath+"/"+fileName+".txt");
		try (Scanner fileReader = new Scanner(myFile)) {
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				input.tokenize(line);
				db.addToDatabase(input.getInputName(), input.getInputAge());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void saveDatabaseToFile(String filePath, String fileName, PetDatabase db) {
		try (FileWriter myWriter = new FileWriter(filePath+"/"+fileName+".txt")) {
			//For each entry in the database, loop through.
			for (int i = 0; i <= 4; i++) {
				try {
				myWriter.write(db.readLine(i)+"\r\n");
				}catch(NullPointerException e) {
					continue;
				}
			}
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
