package org.persistence.tutorial;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class MyUtilitiesTest {

	@Test
	public void saveStringToFile() {
		String saveString = "this in a test line one of two\n" + 
				"this is test line two of two\n";
	File testFile = new File("testsavetostring.txt");	
	testFile.delete();
	assertFalse("File should not exist", testFile.exists());
	
	assertTrue("File should have been saved", 
			MyUtilities.saveStringToFile("testsavetostring.txt",saveString));
	
	String newString = MyUtilities.getStringFromFile("testsavetostring.txt");
	assertTrue("Save and get strings should be equal", saveString.equals(newString));

	assertFalse("File should not be saved", MyUtilities.saveStringToFile(
			"non-existent directory/thisshouldfail",saveString));
	
	String emptyString = MyUtilities.getStringFromFile("badfilename.txt");
	assertTrue("String should be empty", emptyString.length()==0);
	
	
	
	
	
	}

}
