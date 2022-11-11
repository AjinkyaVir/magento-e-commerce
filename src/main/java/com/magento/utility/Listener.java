package com.magento.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.magento.actionDriver.CommonActions;
import com.magento.base.Base;

public class Listener extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName());
		Log.info("Test strated : " + result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			//test.log();
			System.out.println(result.getName());
			Log.info("Pass Test case is: " + result.getName());
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			
			Log.info("Test case fail : " + result.getName());
			try {
			CommonActions.screenShot(driver, result.getName());
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	
	
	

}
