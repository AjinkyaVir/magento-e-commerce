package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class MobileListPage extends Base{
	
	/*
	 * @FindBy(
	 * xpath="//div[@class='category-products']//child::li[@class='item last']//div[@class='product-info']//h2[@class='product-name']/a"
	 * ) private WebElement listOfMobiles;
	 */
	
	@FindBy(xpath = "//span[@id='product-price-1']//span[@class='price']")
	private WebElement mobileCost;
	
	@FindBy(xpath = "//a[text()='Sony Xperia']")
	private WebElement clickMobile;
	
	@FindBy(xpath= "//a[text()='Sony Xperia']//following::div[@class='actions']/button")
	private WebElement clickOnAddToCartBtn;
	
	public MobileListPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	  public String getMobileCost() {
	  
	  String listPageMobileCost = mobileCost.getText(); 
	  
	  return listPageMobileCost;
	  
	  }
	 
	 
	 public MobileDetailPage clickOnMobile() {
		 
		 CommonActions.click(driver, clickMobile);
		 return new MobileDetailPage();
		 
	 }
	 
	 public ShoppinCartPage clickOnAddToCartBtn() {
		 CommonActions.scrollByVisibilityOfElement(driver, clickOnAddToCartBtn);
		 CommonActions.click(driver, clickOnAddToCartBtn);
		 return new ShoppinCartPage();
		 
	 }

}
