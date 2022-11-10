package com.magento.shoppingCart;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;
import com.magento.pageObject.IndexPage;
import com.magento.pageObject.MobileListPage;
import com.magento.pageObject.ShoppinCartPage;

public class TC_ShoppingCart_003 extends Base {

	IndexPage indexPage;
	ShoppinCartPage shoppingCartPage;
	MobileListPage mobileListPage;

	@Test
	public void proudctCount() {

		indexPage = new IndexPage();
		indexPage.clickOnMobileTab();
		
		mobileListPage = new MobileListPage();
		mobileListPage.clickOnAddToCartBtn();

		shoppingCartPage = new ShoppinCartPage();

		CommonActions.implicitWait(driver, 30);

		shoppingCartPage.enterQty("1000");
		shoppingCartPage.clickOnUpdateButton();

		
		String expectedErrorMsg = "Some of the products cannot be ordered in requested quantity.";
		String actualErrorMsg = shoppingCartPage.validateErrorMsg();
		
		Assert.assertEquals(actualErrorMsg,expectedErrorMsg);
		System.out.println("Successfully Executed");
		
		shoppingCartPage.clickOnEmptyBtn();
		String expectedMsg = "SHOPPING CART IS EMPTY";
		String actualMsg = shoppingCartPage.validateEmptyCartMsg();
		CommonActions.assertion(actualMsg, expectedMsg);
		
		System.out.println("End of test");
		
		
	}
	
	

}
