package com.magento.mobileCost;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.magento.base.Base;
import com.magento.pageObject.MobileCostPage;
import com.magento.pageObject.MobileDetailPage;
import com.magento.pageObject.MobileListPage;

public class TC_MobileCostPage_001 extends Base{

	MobileCostPage mobileCostPage;
	MobileListPage mobileListPage;
	MobileDetailPage mobileDetailPage;
	
	@Test
	public void clickOnMobileTab() {
		
		mobileCostPage = new MobileCostPage();
		
		mobileCostPage.clickOnMobile();
		
	}
	
	@Test(dependsOnMethods="clickOnMobileTab")
	public void compareMobileCost() {
		
	mobileListPage = new MobileListPage();
	
	String listPageMobileCost = mobileListPage.getMobileCost();
	System.out.println(listPageMobileCost);

	mobileListPage.clickOnMobile();
	
	mobileDetailPage = new MobileDetailPage();
	String detailPageMobileCost = mobileDetailPage.getDetailPageMobilePrice();
	System.out.println(detailPageMobileCost);
	
	Assert.assertEquals(listPageMobileCost, detailPageMobileCost);
	System.out.println("Success");
	
		
	}
	
	
}
