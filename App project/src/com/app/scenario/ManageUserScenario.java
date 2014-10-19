package com.app.scenario;


import org.testng.Assert;

import com.app.utils.Browser;
import static com.app.utils.Constant.*;


/**
 * This class contains all scenario for Manage User suite class
 * @author Chuot Con
 *
 */

public class ManageUserScenario {

	/**
	 * delete user scenario
	 */
	public static void _deleteUser (Browser browser) {
	   // navigaveTo();
	   // findElement ();
	   // Assert.assertEquals ();
		System.out.println("in delete scenario");
		browser.navigateTo(BASE_URL);
		Assert.assertEquals(browser.getTitle(), "Google");
	}
}
