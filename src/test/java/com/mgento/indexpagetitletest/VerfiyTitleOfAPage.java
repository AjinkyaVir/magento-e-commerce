package com.mgento.indexpagetitletest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;
import com.magento.pageObject.IndexPage;
import com.magento.pageObject.MobileListPage;
import com.magento.utility.Log;
@Listeners(com.magento.utility.Listener.class)
public class VerfiyTitleOfAPage extends Base {

	IndexPage indexPage;
	MobileListPage mobileListPage;

	@Test
	public void VerfiyTitleOfAPage() {

		indexPage = new IndexPage();
		String expectedTitle = "THIS IS DEMO SITE FOR   ";
		String actualTitle = indexPage.verifyPageTitle();

		CommonActions.assertion(actualTitle, expectedTitle);

	}

	@Test
	public void mobilePageTitle() {

		indexPage = new IndexPage();
		indexPage.clickOnMobileTab();
		
		CommonActions.implicitWait(driver, 30);
		mobileListPage = new MobileListPage();
		String expectedTitle = "Mobile";
		String actualTitle = mobileListPage.getWindowTitle();
		Log.info("Mobile Page title : " + actualTitle);
		CommonActions.assertion(actualTitle, expectedTitle);
		
	}
	
	@Test
	public void sortMobileList() {
		
		indexPage = new IndexPage();
		indexPage.clickOnMobileTab();
		
		
		
		
		  mobileListPage = new MobileListPage();
		  mobileListPage.clickOnSortDropDown();
		  mobileListPage.sortMobile(1);
		 
		 
		 
		
			
		
		/*
		 * WebElement e =
		 * driver.findElement(By.xpath("(//select[@title='Sort By'])[1]")); e.click();
		 * Select s = new Select(e); s.selectByIndex(-1);
		 */
			 
		
	}

}
