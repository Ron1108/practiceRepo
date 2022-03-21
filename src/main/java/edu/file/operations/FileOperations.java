package edu.file.operations;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class FileOperations {
	//InputStream propFile;
	Properties pathProperties;
	FileReader propFile;
	File newFileObj;

	public FileOperations() {

		try {
			propFile = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\path.properties");
			pathProperties = new Properties();
			pathProperties.load(propFile);
			newFileObj = new File(pathProperties.getProperty("path"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createNewFile() {
		try {
			if (newFileObj.exists()) {
				System.out.println("File name exits");
			} else {
				newFileObj.createNewFile();
				System.out.println("File Successfully Created");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}

	public void writeToFile(String Input) throws IOException {
		try {
			FileWriter fWriter = new FileWriter(pathProperties.getProperty("path"));
			fWriter.write(Input);
			fWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
		}
	}

	public String readFromFile() {
		String data = "";
		try {
			Scanner fileReader = new Scanner(newFileObj);
			while (fileReader.hasNextLine()) {
				data = fileReader.nextLine();
			}
			fileReader.close();
			return (data);
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			return "";
		}
	}

	public void deleteFile() {
		if (newFileObj.delete() != true) {
			System.out.println("File Dose not exist");
		}
	}
}
