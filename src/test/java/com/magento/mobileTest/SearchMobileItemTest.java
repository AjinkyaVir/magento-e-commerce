package com.magento.mobileTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.magento.base.Base;
import com.magento.pageObject.IndexPage;
import com.magento.pageObject.SearchMobileItems;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class SearchMobileItemTest extends Base{

	IndexPage indexPage;
	SearchMobileItems searchMobileItems;
	

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
	public void verifyPageTitle() {

		//Base.launchApp();

		indexPage = new IndexPage();
		indexPage.clickOnMobileTab();
		Reporter.log("click on mobile tab");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String expectedTitle = "Mobile";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(expectedTitle, actualTitle);
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Mobile Page Tilte is same as expected title");
		} else {
			System.out.println("Tilte is differ from expected title");
		}

	}

	@Test(dependsOnMethods = { "verifyPageTitle" })
	public void clickOnMobileMenu() {

		searchMobileItems = new SearchMobileItems();

		searchMobileItems.clickOnDropDown();

	}

}
