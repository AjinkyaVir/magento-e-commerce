package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.base.Base;

public class MobileDetailPage extends Base{

	@FindBy(xpath = "//span[@class='price']")
	private WebElement detailPageMobilePrice;
	
	public MobileDetailPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String getDetailPageMobilePrice() {
		String finalMoblePrice = detailPageMobilePrice.getText();
		return finalMoblePrice;
	}
	
}
