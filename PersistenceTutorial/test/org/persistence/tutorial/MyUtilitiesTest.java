package org.persistence.tutorial;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class MyUtilitiesTest {

	@Test
	public void saveStringToFile() {
		String saveString = "this in a test line one of two and no more\n"
				+ "this is test line two of two and no more\n";
		File testFile = new File("testsavetostring.txt");
		testFile.delete();
		assertFalse("File should not exist", testFile.exists());

		assertTrue("File should have been saved", MyUtilities.saveStringToFile(
				"testsavetostring.txt", saveString));

		String newString = MyUtilities
				.getStringFromFile("testsavetostring.txt");
		assertTrue("Save and get strings should be equal",
				saveString.equals(newString));

		assertFalse("File should not be saved", MyUtilities.saveStringToFile(
				"non-existent directory/thisshouldfail", saveString));

		String emptyString = MyUtilities.getStringFromFile("badfilename.txt");
		assertTrue("String should be empty", emptyString.length() == 0);

	}

	
	public MyLibrary createMyLibrary() {

		Book b1;
		Book b2;
		Person p1;
		Person p2;
		MyLibrary ml;
		
		b1 = new Book("Book1");
		b2 = new Book("Book2");
		p1 = new Person();
		p1.setName("Fred");
		p2 = new Person();
		p2.setName("Sue");
		ml = new MyLibrary("Test");
		
		ml.addBook(b1);
		ml.addBook(b2);
		ml.addPerson(p1);
		ml.addPerson(p2);
		ml.checkOut(b1, p1);
		return ml;
	}
	
	
	@Test 
	public void convertToXML(){
		MyLibrary startMyLibrary = createMyLibrary();
		String testXMLOut = MyUtilities.convertToXML (startMyLibrary);
		MyLibrary endMyLibrary = MyUtilities.convertFromXML(testXMLOut);
		
		assertEquals("Test", endMyLibrary.getName());
		assertEquals(2,  endMyLibrary.getBooks().size());
		assertEquals(2,  endMyLibrary.getPeople().size());
		assertEquals("Fred", endMyLibrary.getBooks().get(0).getPerson().getName());
		
	}
	
	@Test public void saveToXMLFile() {
		MyLibrary startMyLibrary = createMyLibrary();
		String fileName = "testmylibrary.xml";
		File testFile = new File(fileName);
		testFile.delete();
		assertFalse("File should not exist", testFile.exists());
		assertTrue("File should have been saved", MyUtilities.saveMyLibraryToXMLFile(fileName,startMyLibrary));
		MyLibrary endMyLibrary = MyUtilities.getMyLibraryFromXMLFile(fileName);
		assertEquals("Test", endMyLibrary.getName());
		assertEquals(2,  endMyLibrary.getBooks().size());
		assertEquals(2,  endMyLibrary.getPeople().size());
		assertEquals("Fred", endMyLibrary.getBooks().get(0).getPerson().getName());
		
		
	}
	@Test public void saveToSerialFile() {
		MyLibrary startMyLibrary = createMyLibrary();
		String fileName = "testmylibrary.ser";
		File testFile = new File(fileName);
		testFile.delete();
		assertFalse("File should not exist", testFile.exists());
		assertTrue("File should have been saved", MyUtilities.saveMyLibraryToSerialFile(fileName,startMyLibrary));
		MyLibrary endMyLibrary = MyUtilities.getMyLibraryFromSerialFile(fileName);
		assertEquals("Test", endMyLibrary.getName());
		assertEquals(2,  endMyLibrary.getBooks().size());
		assertEquals(2,  endMyLibrary.getPeople().size());
		assertEquals("Fred", endMyLibrary.getBooks().get(0).getPerson().getName());
		
		
	}
	
	
}
