package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class IndexPage extends Base{

	@FindBy(xpath = "//a[text()='Mobile']")
	private WebElement mobileBtn;
	
	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}



	public SearchMobileItems clickOnMobileTab() {
		
		CommonActions.click(driver, mobileBtn);
		return new SearchMobileItems();
	}
	
	
	
}
