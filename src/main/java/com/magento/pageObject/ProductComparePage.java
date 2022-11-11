package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class ProductComparePage extends Base{
	
	@FindBy(xpath = "//h1['Compare Products']")
	private WebElement verfiyPageHeader;
	
	@FindBy(xpath = "//h2[@class='product-name']//a[@title='IPhone']")
	private WebElement productOneName;
	
	@FindBy(xpath = "//h2[@class='product-name']//a[@title='Samsung Galaxy']")
	private WebElement productTwoName;
	
	
	public ProductComparePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String verifyProductOneName() {
		CommonActions.implicitWait(driver, 10);
		String verifyProductOneName = productOneName.getText();
		return verifyProductOneName;
		
	}
	
	
	public String verifyproductTwoName() {
		CommonActions.implicitWait(driver, 10);
		String verifyProductTwoName = productTwoName.getText().toUpperCase();
		return verifyProductTwoName;
		
	}
	
	public String verifyProdctComparePageTitle() {
		
		String verifyProdctComparePageTitle = verfiyPageHeader.getText().toUpperCase();
		return verifyProdctComparePageTitle;
		
	}
	

}
