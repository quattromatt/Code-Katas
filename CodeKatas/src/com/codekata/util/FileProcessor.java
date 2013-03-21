package com.codekata.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public abstract class FileProcessor {

	private File m_file;
	
	public FileProcessor(String filePath) {
		m_file = new File(filePath);

		if (!m_file.exists()) {
			throw new RuntimeException("File is missing!");
		}
	}
	
	public void processFile() {

		try {
			FileInputStream fis = new FileInputStream(m_file);
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					dis));
			String line;

			while ((line = reader.readLine()) != null) {
				line = line.trim();

				if (line.length() <= 0) {
					continue;
				}

				processLine(line);
			}

			reader.close();
			dis.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract void processLine(String line);
}
