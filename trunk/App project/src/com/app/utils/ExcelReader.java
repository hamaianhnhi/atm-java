package com.app.utils;

import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader {

	public ExcelReader () {
		
	}
	
	
	/**
	 * get data from excel file
	 * @param xmlFilePath
	 * @param sheetName
	 * @param tableName
	 * @return String [][]
	 * @throws BiffException
	 * @throws IOException
	 */
	public static String[][] getTableArray (String xmlFilePath, String sheetName, String tableName) throws BiffException, IOException {
			
			String[][] tabArray  = null ;
			Workbook workBook  = Workbook.getWorkbook(new java.io.File(xmlFilePath));
			Sheet sheet = workBook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol, ci, cj = 0;
			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();
			
			Cell tableEnd = sheet.findCell(tableName, startCol+1, startRow+1, 100, 64000, false);
			endCol = tableEnd.getColumn();
			endRow = tableEnd.getRow();
			
			tabArray = new String[endRow - startRow -1][endCol - startCol -1];
			ci=0;
			for (int i = startRow +1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol+1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j,i).getContents();
				}
			}
			
			return tabArray;
		}
}
