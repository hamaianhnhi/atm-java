package com.app.utils;

import java.util.ArrayList;
import java.util.List;



public class DataSetReader {

	private CSVReader csvReader;
	
	/**
	 * init new {DataSetReader}
	 * @param filePath
	 */
	public  DataSetReader (String filePath) {
		
		this.csvReader = new CSVReader(filePath);
	}
	

	/**
	 * get Data from one field by Field name
	 * @param key
	 * @return
	 */
	public List<String> getDatasetByField (String key) {
		
		List<String> arrData = new ArrayList<String>(); 
		
		arrData = this.csvReader.getDatasetByField(key);
		return arrData;
		
	}
			 
}
	
