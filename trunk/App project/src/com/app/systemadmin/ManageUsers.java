package com.app.systemadmin;


import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import static com.app.utils.Constant.DATASET;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ManageUsers extends TestBase {

	
	
	@DataProvider(name = "invalid")
    public  Object[][] primeNumbers() throws BiffException, IOException {
	    Object[][] data = getTableArray(DATASET, "datasheet", "login");
	    return data;
    }
	
	@Test(dataProvider = "invalid")
	public void validCase1(String username, String password, String expectResult) throws InterruptedException {
		  System.out.println("abc");

	}
	
	public String[][] getTableArray (String xmlFilePath, String sheetName, String tableName) throws BiffException, IOException {
		
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
