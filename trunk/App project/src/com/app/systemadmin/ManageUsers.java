package com.app.systemadmin;


import java.io.IOException;
import jxl.read.biff.BiffException;
import static com.app.utils.Constant.DATASET;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.app.scenario.ManageUserScenario.*;
import com.app.utils.ExcelReader;

/**
 * This class contains all test case for Manage user
 * @author Chuot Con
 *
 */
public class ManageUsers extends BaseSuite {

	
	
	@DataProvider(name = "invalid")
    public  Object[][] primeNumbers() throws BiffException, IOException {
	    Object[][] data = ExcelReader.getTableArray(DATASET, "datasheet", "login");
	    return data;
    }
	
//	@Test(dataProvider = "invalid", description="dhauidyad", priority = 2, dependsOnMethods = {"test23"} )
//	public void validCase1(String username, String password, String expectResult) throws InterruptedException {
//		
//		  System.out.println("abc");
//		  
//
//	}
	
//	@Test(priority = 1)
//	public void test23() {
//		int a = 1/0;
//	}
	
	@Test
	public void deleteUser () {
	
		_deleteUser(getBrowser());
	}
	
}
