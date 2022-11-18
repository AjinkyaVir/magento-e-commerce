package com.magento.actionDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.magento.base.Base;

public class CommonActions extends Base {

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static void scrollByVisibilityOfElement(WebDriver driver,WebElement ele) {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 * 
	 * click() - To click on Web Element
	 * 
	 */
	public static void click(WebDriver driver,WebElement element) {

		boolean flag = false;
		try {
			
			element.isDisplayed();
			Actions act = new Actions(driver);
			act.moveToElement(element).click().build().perform();
			flag = true;
			
		}catch(Exception e) {
			
			System.out.println("Element not visible");
			flag = false;
			
		}finally {
			if(flag) {
				System.out.println("Element is visible");
			}else {
				System.out.println("Element is't visible");
			}
		}
			
	}
	
	/**
	 * 
	 * @param ele
	 * @param text
	 * @return
	 * 
	 * sendKey method to type data in field
	 */
	
	public static boolean type(WebElement ele, String text) {
		
		boolean flag = false;
		try {
			
				flag = ele.isDisplayed();
				ele.clear();
				ele.sendKeys(text);
				flag = true;
				
		}catch(Exception e){
			
			System.out.println("Location not found.");
			flag = false;
			
		}finally {
			
			if(flag) {
				System.out.println("Successfully entered value");
			}else {
				System.out.println("unable to enter value");
			}
			
		}
		return flag;
	
	}
	
	/**
	 * 
	 * @param driver
	 * @param timeOut
	 * 
	 * implicitWait(WebDriver driver,int timeOut) 
	 * 
	 * To apply implicit wait
	 * 
	 */
	public static void implicitWait(WebDriver driver,int timeOut) {
		
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		
	}
	
	/**
	 * Assert.assertEquals(msg1, msg2);
	 * To check expected value and actual value
	 * 
	 * @param msg1
	 * @param msg2
	 */
	public static void assertion(String msg1, String msg2) {
		
		Assert.assertEquals(msg1, msg2);
		
	}
	
	/**
	 * 
	 *  switchToNewWindow(WebDriver driver) - To switch to new window
	 * 
	 * @param driver
	 * @return
	 */
	
	public static boolean switchToNewWindow(WebDriver driver) {
		
		boolean flag = false;
		try {
			
			Set<String> newWindow = driver.getWindowHandles();
			Object[] popUp = newWindow.toArray();
			driver.switchTo().window(popUp[1].toString());
			flag = true;
			return flag;
			
		}catch(Exception e) {
			
			flag = false;
			return flag;
			
		}finally {
			
			if(flag) {
				
				System.out.println("Switched to new Window");
				
			}else {
				
				System.out.println("Not switched to new Window");
				
			}
			
		}
		
	}
	
	/**
	 * 
	 * switchBackToOldWindow(WebDriver driver) - To switch back to main window
	 * 
	 * @param driver
	 * @return
	 */
	
	public static boolean switchBackToOldWindow(WebDriver driver) {
		
		boolean flag = false;
		try {
			
			Set<String> oldWin = driver.getWindowHandles();
			Object[] popUp = oldWin.toArray();
			driver.switchTo().window(popUp[0].toString());
			
			flag = true;
			return flag;
			
		}catch(Exception e) {
			
			flag = false;
			return flag;
		}finally {
			
			if(flag) {
				
				System.out.println("Window switch back to main window");
				
			}else {
				
				System.out.println("Window doesn't switch back to main window.");
				
			}
			
		}
		
		
		
		
		
	}
	
	
	/**
	 * 
	 * getTitle(WebDriver driver) - To get title of a window
	 * 
	 * @param driver
	 * @return
	 */
	
	public static String getTitle(WebDriver driver) {
		
		boolean flag = false;
		
		String title = driver.getTitle();
		if(flag) {
			System.out.println("Title of page " + title);
		}
		return title;
		
	}
	
	/**
	 * 
	 * closeCurrentWindow(WebDriver driver) - To close current window
	 * 
	 */
	public static void closeCurrentWindow(WebDriver driver) {
		
		driver.close();
		
	}

	
	/**
	 * 
	 * screenShot(WebDriver driver,String fileName) - 
	 * To take failed test case screenshot
	 * 
	 * @param driver
	 * @param fileName
	 * @return
	 */
	
	public static String screenShot(WebDriver driver,String fileName) {
		
		// After taking screenshot please update project structure to see captured screenshot
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshot\\" + fileName + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		/*
		 * String newImageString =
		 * "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" +
		 * filename + "_" + dateName + ".png";
		 */
		
		return destination;
	}
	
	
	public static boolean selectByVisibleText(WebElement element,String visbleText) {
		boolean flag = false;
		
		try {
			
			Select select = new Select(element);
			select.selectByVisibleText(visbleText);
			flag = true;
			return true;
			
		}catch(Exception e) {
			return false;
		}finally {
			
			if(flag) {
				System.out.println("Option selected by visible text.");
			}else {
				System.out.println("Option not selected by visible text.");
			}
			
		}
		
	}
	
	public static boolean selectByIndex(WebElement ele,int index) {
		boolean flag = false;
		try {
			
			Select select = new Select(ele);
			select.selectByIndex(index);
			flag = true;
			return true;
			
		}catch(Exception e) {
			System.out.println("Exception == >> " + e);
			flag = false;
			return false;
		}finally {
			
			if(flag) {
				System.out.println("Option selected by index.");
			}else {
				System.out.println("Option not selected by index.");
			}
			
		}
		
	}
	
	
	
	
	
}
