package com.app.systemadmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.app.utils.UIMapReader;
import static com.app.utils.Constant.UIMAP_SINTEL;

public class ManageUsers extends TestBase {

	
	
	@DataProvider(name = "invalid")
    public static Object[][] primeNumbers() {
	    return new Object[][]{
	    		{"dung.pham", "hcm"},
	    		{"anh.pham", "ha noi"}
	    };
    }
	
	@Test
	public void validCase1() throws InterruptedException {
		  
		UIMapReader userMapReader = new UIMapReader(UIMAP_SINTEL);
		String url = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";
		getBrowser().navigateTo(url);
		WebElement productBtn = getBrowser().findElement(userMapReader.readByKey("tryit"));
		productBtn.click();
		getBrowser().wait(3000);
	}
	
//	@Test
//	public void validCase2() {
//		  
//			  UIMapReader userMapReader = new UIMapReader("src/UI Maps/SinTel.properties");
//			  
//				String url = "http://www.absolute.com/en";
//				getBrowser().navigateTo(url);
//				WebElement productBtn = getBrowser().findElement(userMapReader.readByKey("product"));
//				productBtn.click();
//	}
}
