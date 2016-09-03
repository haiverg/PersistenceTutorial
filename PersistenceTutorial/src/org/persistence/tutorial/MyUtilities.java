package org.persistence.tutorial;

import java.io.*;

public class MyUtilities {

	public static boolean saveStringToFile(String fileName, String saveString) {
		boolean saved = false;
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(fileName));
			try {
				bw.write(saveString);
				saved = true;
			} finally {
				bw.close();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return saved;

	}

	public static String getStringFromFile(String fileName) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(fileName));
			try {
				String s;
				while ((s = br.readLine()) != null) {
					// add lineFeed back since stripped by readLine()
					sb.append(s);
					sb.append("\n");

				}
			} finally {
				br.close();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return sb.toString();
	}

}
