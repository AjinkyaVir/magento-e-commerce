package com.magento.accountRegistration;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.magento.base.Base;
import com.magento.pageObject.MyAccountPage;
import com.magento.pageObject.RegistrationPage;
import com.magento.utility.Log;

public class TC_Registration_005 extends Base{
	
	MyAccountPage myAccountPage;
	RegistrationPage registrationPage;
	
	@Test
	public void accountRegistration() {
		
		Log.info("*************Account Regsration Test Case Initiated**********");
		
		myAccountPage = new MyAccountPage();
		myAccountPage.clickOnAccount();
		myAccountPage.clickOnMyAccountLink();
		myAccountPage.clickOnCreateAccountPage();
		
		Log.info("*********Account Regsration Test Case Successful**************");
		
		Log.info("************Registration initiated***********");
		registrationPage = new RegistrationPage();
		
		String firstName = registrationPage.insertFirstName("Vanita");
		
		String middleName = registrationPage.insertMiddelName("Mohan");
		String lastName = registrationPage.insertLastname("More");
		registrationPage.insertEmailIDd("more.vanita@gmail.com");
		registrationPage.insertPassword("vanitaMore");
		registrationPage.insertConfirmPassword("vanitaMore");
		registrationPage.clickOnRegister();
		
		 String expectedResult = ("Welcome, " + firstName + " " + middleName + " " + lastName +"!").toUpperCase();
		 Log.info(expectedResult);
		 String actualResult = registrationPage.verifyCheckWelComeMsg().toUpperCase();
		 Log.info(actualResult);
		
		 Assert.assertEquals(actualResult, expectedResult);
		
	}
	

}
