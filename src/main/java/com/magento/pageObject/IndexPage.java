package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class IndexPage extends Base{

	@FindBy(xpath = "//a[text()='Mobile']")
	private WebElement mobileBtn;
	
	@FindBy(xpath = "//a[text()='TV']")
	private WebElement tvBtn;
	
	@FindBy(xpath = "//div[@class='page-title']")
	private WebElement pageTitle;
	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}



	public SearchMobileItems clickOnMobileTab() {
		
		CommonActions.click(driver, mobileBtn);
		return new SearchMobileItems();
	}
	
	public TvListPage clickOnTvBtn() {
		
		CommonActions.click(driver, tvBtn);
		return new TvListPage();
		
	}
	
	public String verifyPageTitle() {
		String verfiyTitle = pageTitle.getText().toUpperCase();
		return verfiyTitle;
		
	}
	
	public String verifyWebsiteTitle() {
		
		String webSiteTitle = CommonActions.getTitle(driver);
		return webSiteTitle;
		
	}
	
}
