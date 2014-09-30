package com.app.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	private WebDriver driver;
	private String chromePath ="ReferenceLibraries/chromedriver.exe";
	private String iePath="ReferenceLibraries/IEDriverServer.exe";
	
	/**
	 * init new driver
	 * @throws MalformedURLException 
	 */
	public Browser (String browserType) {
		switch (BrowserType.fromString(browserType)) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", chromePath);
			this.driver = new ChromeDriver();
			break;
		case FIREFOX:
			this.driver = new FirefoxDriver();
			break;
		case IE:
			System.setProperty("webdriver.ie.driver", iePath);
			this.driver = new InternetExplorerDriver();
			break;
		case ANDROID:

			break;
		
		default:
			break;
		}
	}
	
	/**
	 * Go to URL
	 * @param url
	 */
	public void navigateTo(String url) {
		this.driver.get(url);
		System.out.println("Go to page>>>> "+ url );
	}
	/**
	 * Close browser
	 */
	public void exit() {
		this.driver.close();
		this.driver.quit();
		System.out.println("Closed browser!");
	}
	
	/**
	 * Click on element
	 * @param element
	 */
	public void clickOnElement(WebElement element) {
		
		element.click();
	}
	
	/**
	 * find list of Element
	 * @param str value of locator
	 * @return
	 */
	public List<WebElement> findElements(String str) {
		
		String locatorType = "";
		String locateValue = "";
		String arrstr[] = str.split("::");
		locatorType = arrstr[0];
		locateValue = arrstr[1];
		List<WebElement> arrResult = null;
		
		switch (LocatorType.fromString(locatorType)) {
		case XPATH:
			arrResult = driver.findElements(By.xpath(locateValue));
			break;
		case ID:
			arrResult = driver.findElements(By.id(locateValue));
			break;
		case NAME:
			arrResult = driver.findElements(By.name(locateValue));
			break;
		case TAGNAME:
			arrResult = driver.findElements(By.tagName(locateValue));
			break;
		case LINKTEXT:
			arrResult = driver.findElements(By.linkText(locateValue));
			break;
		case PARTIAL_LINKTEXT:
			arrResult = driver.findElements(By.partialLinkText(locateValue));
			break;
		case CLASSNAME:
			arrResult = driver.findElements(By.className(locateValue));
			break;
		case CSS:
			arrResult = driver.findElements(By.cssSelector(locateValue));
			break;
		
		default:
			break;
		}

		return arrResult;
	}
	
	/**
	 * find one element
	 * @param str
	 * @return WebElement
	 */
	public WebElement findElement( String str) {
		
		String locatorType = "";
		String locateValue = "";
		String arrstr[] = str.split("::");
		locatorType = arrstr[0];
		locateValue = arrstr[1];
		WebElement result = null;
		
		switch (LocatorType.fromString(locatorType)) {
		case XPATH:
			result = driver.findElement(By.xpath(locateValue));
			break;
		case ID:
			result = driver.findElement(By.id(locateValue));
			break;
		case NAME:
			result = driver.findElement(By.name(locateValue));
			break;
		case TAGNAME:
			result = driver.findElement(By.tagName(locateValue));
			break;
		case LINKTEXT:
			result = driver.findElement(By.linkText(locateValue));
			break;
		case PARTIAL_LINKTEXT:
			result = driver.findElement(By.partialLinkText(locateValue));
			break;
		case CLASSNAME:
			result = driver.findElement(By.className(locateValue));
			break;
		case CSS:
			result = driver.findElement(By.cssSelector(locateValue));
			break;
		
		default:
			break;
		}

		return result;
	}
	
	/**
	 * get Page Title
	 * @return String
	 */
	public String getTitle() {
		return driver.getTitle();
	}
	

	/**
	 * take screen shot
	 * @return File
	 */
	public File takeScreenshot() {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		return scrFile;
	}
}
