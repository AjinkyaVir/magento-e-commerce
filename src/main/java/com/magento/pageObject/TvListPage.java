package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class TvListPage extends Base{
	
	
	@FindBy(xpath = "(//a[text()='Add to Wishlist'])[1]")
	private WebElement clickOnAddToWishListBtn;
	
	public TvListPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	

	public MyWishListPage clickOnAddToWishListBtn() {
		CommonActions.scrollByVisibilityOfElement(driver, clickOnAddToWishListBtn);
		CommonActions.click(driver, clickOnAddToWishListBtn);
		return new MyWishListPage();
		
	}
	
}
