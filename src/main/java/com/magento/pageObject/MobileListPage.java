package com.magento.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class MobileListPage extends Base {

	/*
	 * @FindBy(
	 * xpath="//div[@class='category-products']//child::li[@class='item last']//div[@class='product-info']//h2[@class='product-name']/a"
	 * ) private WebElement listOfMobiles;
	 */
	
	@FindBy(xpath = "(//select[@title='Sort By'])[1]")
	private WebElement sortMobile;
	
	@FindBy(xpath = "//span[@id='product-price-1']//span[@class='price']")
	private WebElement mobileCost;

	@FindBy(xpath = "//a[text()='Sony Xperia']")
	private WebElement clickMobile;

	@FindBy(xpath = "//a[text()='Sony Xperia']//following::div[@class='actions']/button")
	private WebElement clickOnAddToCartBtn;

	@FindBy(xpath = "//div[@class='product-info']//following::a[@title='Samsung Galaxy']//following::div//child::a[@class='link-compare']")
	private WebElement clickOnSamsungCompareToButton;

	@FindBy(xpath = "//div[@class='product-info']//following::a[@title='IPhone']//following::div//child::a[@class='link-compare']")
	private WebElement clickOnIphoneCompareToButton;

	@FindBy(xpath = "//span[text()='Compare']")
	private WebElement clickOnCompareBtn;

	public MobileListPage() {

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

	public void clickOnIphoneCompareToButton() {
		CommonActions.click(driver, clickOnIphoneCompareToButton);
	}

	public void clickOnSamsungCompareToButton() {
		CommonActions.click(driver, clickOnSamsungCompareToButton);
	}

	public void clickOnCompareButton() {
		CommonActions.click(driver, clickOnCompareBtn);
	}

	public String getWindowTitle() {

		String title = CommonActions.getTitle(driver);
		System.out.println(title);
		return title;

	}
	
	public void switchWindow(WebDriver driver) {
		
		CommonActions.switchToNewWindow(driver);
		
	}
	
	public void switchBackToOldWindow(WebDriver driver) {
		CommonActions.switchBackToOldWindow(driver);
	}
	
	public void closeCurrentWindow() {
		CommonActions.closeCurrentWindow(driver);
	}

	public void sortMobile(int index) {
		
		CommonActions.click(driver, sortMobile);
		
		CommonActions.selectByIndex(sortMobile, index);
	}
	
}
