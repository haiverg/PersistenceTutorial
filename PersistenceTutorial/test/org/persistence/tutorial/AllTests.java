package org.persistence.tutorial;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses(value={
		PersonTest.class, 
		BookTest.class,
		MyLibraryTest.class
})


public class AllTests {
	
}