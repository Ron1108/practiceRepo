package basic.file.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import edu.file.operations.FileOperations;

public class BasicFileTests {
	FileOperations fileObject = new FileOperations();
	FileReader fileReaderForTest;
	File testFile;
	Properties fileProp;
	String sampleText, checkText;

	@Before
	public void initFile() throws IOException {
		//fileReaderForTest = getClass().getClassLoader().getResourceAsStream(("user.dir") + "src\\test\\resource\\path.properties");
		fileReaderForTest = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\path.properties");
		fileProp = new Properties();
		fileProp.load(fileReaderForTest);
		testFile = new File(fileProp.getProperty("path"));
		testFile.createNewFile();
		sampleText = fileProp.getProperty("samp");
		checkText = fileProp.getProperty("check");
	}

//	@After
//	public void destroyFile()
//	{
//		if(testFile.exists())
//			testFile.delete();
//	}
	@Test
	public void checkCreateNewFile() {
		// destroyFile();
		fileObject.createNewFile();
		File testFile = new File(fileProp.getProperty("path"));
		assertEquals(true, testFile.exists());
		System.out.println("Test 1 ok");
	}

	@Test
	public void checkWriteFile() throws IOException {
		fileObject.writeToFile(sampleText);
		System.out.println("Test 2 ok");
		assertEquals(checkText, fileObject.readFromFile());
	}

	@Test
	public void checkReadFile() {
		assertEquals(checkText, fileObject.readFromFile());
		System.out.println("Test 3 ok");
	}
//	@Test
//	public void checkDelete()
//	{
//		fileObject.deleteFile();
//		assertEquals(false,testFile.exists());
//	}
}
