package com.magento.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class ShoppinCartPage extends Base {

	@FindBy(xpath = "//input[@title='Qty']")
	private WebElement enterQty;

	@FindBy(xpath = "//td[@class='product-cart-actions']//button[@value='update_qty']")
	private WebElement clickOnUpdateButton;

	@FindBy(xpath = "//span[text()='Some of the products cannot be ordered in requested quantity.']")
	private WebElement validateErroMsg;
	
	@FindBy(xpath = "//span[text()='Empty Cart']")
	private WebElement clickOnEmptyBtn;
	
	@FindBy(xpath= "//h1['Shopping Cart is Empty']")
	private WebElement validateEmptyCartMsg;

	public ShoppinCartPage() {

		PageFactory.initElements(driver, this);

	}

	public String validateErrorMsg() {
		
		String validateErrorMsg = validateErroMsg.getText();
				return validateErrorMsg;
		
	}

	public void enterQty(String qty) {

		CommonActions.type(enterQty, qty);

	}

	public void clickOnUpdateButton() {

		CommonActions.click(driver, clickOnUpdateButton);

	}
	
	public void clickOnEmptyBtn() {
		
		CommonActions.click(driver, clickOnEmptyBtn);
		
	}
	
	public String validateEmptyCartMsg() {
		
		String validateEmptyCartMessage = validateEmptyCartMsg.getText().toUpperCase();
		return validateEmptyCartMessage;
		
	}

}
