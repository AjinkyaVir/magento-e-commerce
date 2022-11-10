package com.magento.mobileListPageTest;

import org.testng.annotations.Test;

import com.magento.base.Base;
import com.magento.pageObject.IndexPage;
import com.magento.pageObject.MobileListPage;
import com.magento.pageObject.ShoppinCartPage;

public class TC_MobileListPageTest_005 extends Base{

	IndexPage indexPage;
	ShoppinCartPage shoppingCartPage;
	MobileListPage mobileListPage;
	
	@Test
	public void compareProduct() throws InterruptedException {
		
		indexPage = new IndexPage();
		indexPage.clickOnMobileTab();
		
		mobileListPage = new MobileListPage();
		
		mobileListPage.clickOnSamsungCompareToButton();
		mobileListPage.clickOnIphoneCompareToButton();
		mobileListPage.clickOnCompareButton();
		
		mobileListPage.switchWindow(driver);
		mobileListPage.getWindowTitle();
		mobileListPage.closeCurrentWindow();
		mobileListPage.switchBackToOldWindow(driver);
		mobileListPage.getWindowTitle();
	
		Thread.sleep(2000);
		
		System.out.println("executed successfully!!!");
		
	}
	
}
