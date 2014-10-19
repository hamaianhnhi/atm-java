package com.app.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static com.app.utils.Constant.SCREENSHOT_PATH;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.app.utils.Constant.CHROME_PATH;
import static com.app.utils.Constant.IE_PATH;

public class Browser {

	private WebDriver driver;
	
	/**
	 * init new driver
	 * @throws MalformedURLException 
	 */
	public Browser (String browserType) {
		switch (BrowserType.fromString(browserType)) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", CHROME_PATH);
			this.driver = new ChromeDriver();
			break;
		case FIREFOX:
			this.driver = new FirefoxDriver();
			break;
		case IE:
			System.setProperty("webdriver.ie.driver", IE_PATH );
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
		highlightElement(element);
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
		String arrstr[] = split(str, "::");
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
		String arrstr[] = split(str, "::");
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
	 * @throws IOException 
	 */
	public File takeScreenshot()  {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		//get current date time with Date()
		Date date = new Date();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(SCREENSHOT_PATH +dateFormat.format(date).toString()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return scrFile;
	}
	
	/**
	 * split string to String [] by regex
	 * @param str
	 * @param regex
	 * @return array of String
	 */
	public String[] split(String str, String regex) {
		String arrstr[] = str.split(regex);
		return arrstr;
	}
	
	/**
	 * high light element
	 * @param element
	 */
	public void highlightElement(WebElement element) {

	    for (int i = 0; i < 2; i++) {

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",

	                element, "color: yellow; border: 2px solid yellow;");

	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",

	                element, "");

	    }

	}
}
