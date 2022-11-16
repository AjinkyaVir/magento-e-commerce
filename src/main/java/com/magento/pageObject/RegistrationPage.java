package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class RegistrationPage extends Base{
	
	@FindBy(xpath = "//p[@class='welcome-msg']")
	private WebElement verifyCheckWelComeMsg;
	
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement insertFirstName;
	
	@FindBy(xpath = "//input[@id='middlename']")
	private WebElement insertMiddelName;
	
	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement insertLastname;
	
	@FindBy(xpath = "//input[@id='email_address']")
	private WebElement insertEmailId;
	
	@FindBy(xpath = "//input[@id=\"password\"]")
	private WebElement insertPassword;
	
	@FindBy(xpath = "//input[@id='confirmation']")
	private WebElement insertConfirmPassword;
	
	@FindBy(xpath = "//span[text()='Register']")
	private WebElement clickOnRegister;
	
	
	public RegistrationPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyCheckWelComeMsg() {
		
		String verifyWelComeMsg = verifyCheckWelComeMsg.getText();
		return verifyWelComeMsg;
		
	}
	
	public String insertFirstName(String firstName) {
		CommonActions.type(insertFirstName, firstName);
		return firstName;
	}
	
	public String insertMiddelName(String middleName) {
		CommonActions.type(insertMiddelName, middleName);
		return middleName;
	}
	
	public String insertLastname(String lastname) {
		CommonActions.type(insertLastname, lastname);
		return lastname;
	}
	
	public void insertEmailIDd(String emialId) {
		CommonActions.type(insertEmailId, emialId);
	}
	
	public void insertPassword(String password) {
		CommonActions.type(insertPassword, password);
	}
	public void insertConfirmPassword(String confirmPassword) {
		CommonActions.type(insertConfirmPassword, confirmPassword);
	}
	public void clickOnRegister() {
		CommonActions.click(driver, clickOnRegister);
	}
	
	
}
