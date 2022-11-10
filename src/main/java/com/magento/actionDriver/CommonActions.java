package com.magento.actionDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
			
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
	
	
}
