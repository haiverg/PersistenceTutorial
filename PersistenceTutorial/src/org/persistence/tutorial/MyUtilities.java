package org.persistence.tutorial;

import java.io.*;

public class MyUtilities {

	public static boolean saveStringToFile(String fileName, String saveString) {
		boolean saved = false;
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(
					new FileWriter(fileName));
			try {
				bw.write(saveString);
				saved = True;
			} 
			finally {
				bw.close();
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return saved;
		
	}

	
	public static String getStringFromFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
