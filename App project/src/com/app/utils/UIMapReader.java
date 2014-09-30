package com.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class UIMapReader {

	private Properties PropertiesFile;
//	private String filePath;
	
	/**
	 * init new UIMapReader
	 * @param filePath
	 */
	public UIMapReader (String filePath) {
		
//		this.filePath = filePath;
		this.PropertiesFile = new Properties();
		try {
			
			File file = new File(filePath);
			FileInputStream fileInput = new FileInputStream(file);
			this.PropertiesFile.load(fileInput);
			fileInput.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	/**
	 * get value by key
	 * @param key
	 */
	public String readByKey(String key) {
		String result = "";
		try {
			result  = this.PropertiesFile.getProperty(key);
		} catch (Exception e) {
			System.err.println(e);
		}
		return result;
	}
	
}
