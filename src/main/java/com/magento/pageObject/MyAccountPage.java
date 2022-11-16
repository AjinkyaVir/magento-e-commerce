package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class MyAccountPage extends Base{

	CommonActions actions;
	
	@FindBy(xpath = "(//span[text()='Account'])[1]")
	private WebElement clickAccount;
	
	@FindBy(xpath = "(//a[text()='My Account'])[1]")
	private WebElement clickOnMyAccountLink;
	
	@FindBy(xpath = "//a[@title='Create an Account']")
	private WebElement clickOnCreateAccountPage;
	
	
	public MyAccountPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickOnAccount() {
		
		actions.click(driver, clickAccount);
		
	}
	
	public void clickOnMyAccountLink() {
		actions.click(driver, clickOnMyAccountLink);
	}
	
	public RegistrationPage clickOnCreateAccountPage(){
		actions.click(driver, clickOnCreateAccountPage);
		return new RegistrationPage();
	}
	
}
