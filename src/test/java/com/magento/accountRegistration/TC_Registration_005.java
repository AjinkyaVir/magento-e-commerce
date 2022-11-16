package com.magento.accountRegistration;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;
import com.magento.pageObject.IndexPage;
import com.magento.pageObject.MyAccountPage;
import com.magento.pageObject.MyWishListPage;
import com.magento.pageObject.RegistrationPage;
import com.magento.pageObject.TvListPage;
import com.magento.utility.Log;
@Listeners(com.magento.utility.Listener.class)
public class TC_Registration_005 extends Base{
	
	MyAccountPage myAccountPage;
	RegistrationPage registrationPage;
	IndexPage indexPage;
	TvListPage tvListPage;
	MyWishListPage myWishListPage;
	
	@Test(priority = 1)
	public void accountRegistration() {
		
		Log.info("*************Account Regsration Test Case Initiated**********");
		
		myAccountPage = new MyAccountPage();
		myAccountPage.clickOnAccount();
		myAccountPage.clickOnMyAccountLink();
		myAccountPage.clickOnCreateAccountPage();
		
		Log.info("*********Account Regsration Test Case Successful**************");
		
		Log.info("************Registration initiated***********");
		registrationPage = new RegistrationPage();
		
		String firstName = registrationPage.insertFirstName("qweer");
		
		String middleName = registrationPage.insertMiddelName("Mohan");
		String lastName = registrationPage.insertLastname("More");
		registrationPage.insertEmailIDd("more.qwerr@gmail.com");
		registrationPage.insertPassword("asdfghjkl");
		registrationPage.insertConfirmPassword("asdfghjkl");
		registrationPage.clickOnRegister();
		
		 String expectedResult = ("Welcome, " + firstName + " " + middleName + " " + lastName +"!").toUpperCase();
		 Log.info(expectedResult);
		 String actualResult = registrationPage.verifyCheckWelComeMsg().toUpperCase();
		 Log.info(actualResult);
		
		 Assert.assertEquals(actualResult, expectedResult);
		
	}
	
	@Test(priority = 2)
	public void addProductIntoWishList() {
		
		indexPage = new IndexPage();
		indexPage.clickOnTvBtn();
		Log.info("*****Tv btn click**********");
		
		CommonActions.implicitWait(driver, 30);
		
		tvListPage = new TvListPage();
		
		tvListPage.clickOnAddToWishListBtn();
		Log.info("*****Tv btn click**********");
		
		myWishListPage = new MyWishListPage();
		myWishListPage.clickShareWishlistBtn();
		Log.info("*****share wishlist success**********");
		myWishListPage.enterEmailAddress("abc@gmail.com");
		Log.info("*****email entered success**********");
		myWishListPage.clickShareWishlistBtn1();
		Log.info("*****mail share wishlist success**********");
		
		Log.info("*****success**********");
		
	}
	

}
