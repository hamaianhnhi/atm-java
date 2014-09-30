package com.app.utils;

public enum BrowserType {

	CHROME("chrome"), IE("ie"), FIREFOX("firefox"), ANDROID("android");
	private String browserCode;

	/**
	 * init new {LocatorType}
	 * @param s
	 */
	private BrowserType (String s) {
		browserCode = s;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBrowserCode() {
		return browserCode;
	}
	
	/**
	 * constructor for LocatorType from String
	 * @param browserType
	 * @return
	 */
	public static BrowserType fromString(String browserType) {
		    if (browserType != null) {
		      for (BrowserType b : BrowserType.values()) {
		        if (browserType.equalsIgnoreCase(b.browserCode)) {
		          return b;
		        }
		      }
		    }
	    return null;	
	}
}
