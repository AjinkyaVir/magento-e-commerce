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
	
	@FindBy(xpath = "(//span[text()='Account'])[1]")
	private WebElement clickAccountTab;
	
	@FindBy(xpath = "(//a[text()='My Account'])[1]")
	private WebElement clickOnMyAccountLink;
	
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
	
	public void clickAccountTab() {
		CommonActions.click(driver, clickAccountTab);
	}
	
	public void clickOnMyAccountLink() {
		CommonActions.click(driver, clickOnMyAccountLink);
	}
	
}
