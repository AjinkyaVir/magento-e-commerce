package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class MyWishListPage extends Base{

	@FindBy(xpath = "//button[@title='Share Wishlist']")
	private WebElement shareWishlistBtn;
	
	@FindBy(xpath = "//textarea[@id='email_address']")
	private WebElement enterEmailAddress;
	
	@FindBy(xpath = "//button[@title='Share Wishlist']")
	private WebElement clickShareWishlistBtn;
	
	
	
	public MyWishListPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickShareWishlistBtn() {
		CommonActions.click(driver, shareWishlistBtn);
	}
	
	public void enterEmailAddress(String email) {
		
		CommonActions.type(enterEmailAddress, email);
		
	}
	
	public void clickShareWishlistBtn1() {
		CommonActions.scrollByVisibilityOfElement(driver, clickShareWishlistBtn);
		CommonActions.click(driver, clickShareWishlistBtn);
		
	}
	
	
	
}
