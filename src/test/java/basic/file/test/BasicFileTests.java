package basic.file.test;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import edu.file.operations.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BasicFileTest {
	FileOperations fileObject = new FileOperations();
	FileReader fileReaderForTest;
	File testFile;
	Properties fileProp;
	String sampleText, checkText;

	@BeforeEach
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

	@AfterAll
	public void destroyFile()
	{
//		if(testFile.exists())
//			testFile.delete();
	}
	@Test
	@Order(1)
	public void checkCreateNewFile() {
		destroyFile();
		fileObject.createNewFile();
		File testFile = new File(fileProp.getProperty("path"));
		assertEquals(true, testFile.exists());
		System.out.println("Test 1 ok");
	}

	@Test
	@Order(2)
	public void checkWriteFile() throws IOException {
		fileObject.writeToFile(sampleText);
		System.out.println("Test 2 ok");
		assertEquals(checkText, fileObject.readFromFile());
	}

	@Test
	@Order(3)
	public void checkReadFile() {
		assertEquals(checkText, fileObject.readFromFile());
		System.out.println("Test 3 ok");
	}
	@Test
	@Order(6)
	public void checkDelete()
	{
		fileObject.deleteFile();
		assertEquals(false,testFile.exists());
	}
}
