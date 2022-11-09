package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class SearchMobileItems extends Base{

	
	@FindBy(xpath = "(//select[@title='Sort By'])[1]")
	private WebElement selectDropDown;
	
	public SearchMobileItems() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnDropDown() {
		
		CommonActions.click(driver, selectDropDown);
		
	}
	

}
