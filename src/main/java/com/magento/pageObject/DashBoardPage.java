package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class DashBoardPage extends Base{

	@FindBy(xpath = "//a[text()='My Wishlist']")
	private WebElement clickOnWishlistPage;
	
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnWishlistPage() {
		
		CommonActions.click(driver, clickOnWishlistPage);
		
	}
	
}
