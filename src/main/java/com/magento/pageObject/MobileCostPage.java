package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class MobileCostPage extends Base{
	
	@FindBy(xpath = "//a[text()='Mobile']")
	private WebElement mobileMenu;
	
	public MobileCostPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public MobileListPage clickOnMobile() {
		
		CommonActions.click(driver, mobileMenu);
		
		return new MobileListPage();
		
	}
	
	
}
