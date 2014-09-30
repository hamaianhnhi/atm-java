package com.app.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	
	private BufferedReader bufferedReader;
	private String cvsSplitBy;
	private String filePath;
	

	/**
	 * init new {CSVReader}
	 * @param filePath
	 */
	public CSVReader ( String filePath ) {
		
		this.bufferedReader = null;
		this.cvsSplitBy = ",";
		this.filePath = filePath;
		
	}
	
	/**
	 * get Data of a FIELD by FIELDNAME
	 * 
	 * @return List<String>
	 */
	public List<String> getDatasetByField(String fieldName) {

		List<String> arrData = new ArrayList<String>();
		String line = "";
		String firstRow = "";
		int fieldIndex = 0;
		try {

			this.bufferedReader = new BufferedReader(new FileReader(filePath));
			try {

				firstRow = this.bufferedReader.readLine();

			} catch (Exception e) {
				System.err.println(e);
			}
			String[] header = firstRow.split(this.cvsSplitBy);
			// get field index
			for (int i = 0; i < header.length; i++) {
				if (header[i] == fieldName) {
					fieldIndex = i;
				}
			}

			try {
				while ((line = this.bufferedReader.readLine()) != null) {

					// use comma as separator
					String[] data = line.split(this.cvsSplitBy);
					arrData.add(data[fieldIndex]);

				}
			} catch (Exception e) {
				System.err.println(e);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (this.bufferedReader != null) {
				try {
					this.bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return arrData;
	}
}
