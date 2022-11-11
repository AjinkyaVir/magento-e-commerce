package com.magento.mobileListPageTest;

import org.testng.annotations.Test;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;
import com.magento.pageObject.IndexPage;
import com.magento.pageObject.MobileListPage;
import com.magento.pageObject.ProductComparePage;
import com.magento.pageObject.ShoppinCartPage;
import com.magento.utility.Log;

public class TC_MobileListPageTest_005 extends Base{

	IndexPage indexPage;
	ShoppinCartPage shoppingCartPage;
	MobileListPage mobileListPage;
	ProductComparePage productComparePage;
	
	@Test
	public void compareProduct() throws InterruptedException {
		Log.startTestCase("compareProduct");
		indexPage = new IndexPage();
		indexPage.clickOnMobileTab();
		Log.info("Mobile Tab is clicked");
		mobileListPage = new MobileListPage();
		
		mobileListPage.clickOnSamsungCompareToButton();
		mobileListPage.clickOnIphoneCompareToButton();
		mobileListPage.clickOnCompareButton();
		
		Log.info("Compare Button is clicked");
		
		mobileListPage.switchWindow(driver);
		Log.info("Switch to new window successfully");
		mobileListPage.getWindowTitle();
		Log.info("Windows Title printed successfully");
		
		
		productComparePage = new ProductComparePage();
		String expectedProduct = "IPHONE";
		String actualProduct = productComparePage.verifyProductOneName();
		Log.info(actualProduct);
		CommonActions.assertion(actualProduct, expectedProduct);
		
		String expectedProductTwo = "SAMSUNG GALAXY";
		String actualProductTwo = productComparePage.verifyproductTwoName();
		Log.info(actualProductTwo);
		CommonActions.assertion(actualProductTwo, expectedProductTwo);
		mobileListPage.closeCurrentWindow();
		
		mobileListPage.switchBackToOldWindow(driver);
		Log.info("Switch back to old window successfully");
		mobileListPage.getWindowTitle();
	
		Thread.sleep(2000);
		
		System.out.println("executed successfully!!!");
		Log.endTestCase("compareProduct");
	}
	
}
