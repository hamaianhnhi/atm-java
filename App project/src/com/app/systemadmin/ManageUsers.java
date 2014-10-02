package com.app.systemadmin;


import java.io.IOException;
import jxl.read.biff.BiffException;
import static com.app.utils.Constant.DATASET;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.utils.ExcelReader;

public class ManageUsers extends TestBase {

	
	
	@DataProvider(name = "invalid")
    public  Object[][] primeNumbers() throws BiffException, IOException {
	    Object[][] data = ExcelReader.getTableArray(DATASET, "datasheet", "login");
	    return data;
    }
	
	@Test(dataProvider = "invalid")
	public void validCase1(String username, String password, String expectResult) throws InterruptedException {
		  System.out.println("abc");

	}
	
	
}
