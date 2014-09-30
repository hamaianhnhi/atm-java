package com.app.utils;

public enum LocatorType {
	
	XPATH("xpath"), ID("id"), NAME("name"), TAGNAME("tagname"), LINKTEXT("linktext"), PARTIAL_LINKTEXT("plinktext"), CLASSNAME("classname"), CSS("css");
	private String locatorCode;

	/**
	 * init new {LocatorType}
	 * @param s
	 */
	private LocatorType (String s) {
		locatorCode = s;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLocatorCode() {
		return locatorCode;
	}
	
	/**
	 * constructor for LocatorType from String
	 * @param locatorType
	 * @return
	 */
	public static LocatorType fromString(String locatorType) {
		    if (locatorType != null) {
		      for (LocatorType b : LocatorType.values()) {
		        if (locatorType.equalsIgnoreCase(b.locatorCode)) {
		          return b;
		        }
		      }
		    }
	    return null;	
	}
}
