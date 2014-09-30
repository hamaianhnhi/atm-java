package com.app.systemadmin;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.app.utils.Browser;

public class TestBase {
	
	protected ThreadLocal<Browser> threadBrowser = null;
	
	@BeforeMethod
	public void beforeTest () throws MalformedURLException {
		this.threadBrowser = new ThreadLocal<Browser>();
		this.threadBrowser.set(new Browser("chrome"));
	}
	
	@AfterMethod
	public void afterTest (){
		getBrowser().exit();
		
	}
	/**
	 * get Browser
	 * @return Browser
	 */
	public Browser getBrowser() {
		return this.threadBrowser.get();
	}

}
