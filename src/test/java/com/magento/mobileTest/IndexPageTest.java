package com.magento.mobileTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.base.Base;
import com.magento.pageObject.IndexPage;

public class IndexPageTest extends Base {

	IndexPage indexPage;
	
	  
	/*
	 * @BeforeMethod public void setUp() {
	 * 
	 * launchApp();
	 * 
	 * }
	 * 
	 * @AfterMethod public void close() {
	 * 
	 * tearDown();
	 * 
	 * }
	 */
	 

	@Test
	public void verifyTitle() {

		//Base.launchApp();

		String expectedTitle = "Home page";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(expectedTitle, actualTitle);
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Index Page Tilte is same as expected title");
		} else {
			System.out.println("Tilte is differ from expected title");
		}

	}

	@Test(dependsOnMethods = "verifyTitle")
	public void clickOnMobileTab() {

		indexPage = new IndexPage();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		indexPage.clickOnMobileTab();

	}

}
