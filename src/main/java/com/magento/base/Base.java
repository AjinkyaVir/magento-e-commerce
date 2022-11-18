package com.magento.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	
	public static Properties prop;
	public static WebDriver driver;
	

	/*
	 * // Declare ThreadLocal Driver public static ThreadLocal<RemoteWebDriver>
	 * driver = new ThreadLocal<>();
	 * 
	 * public static WebDriver getDriver() { // Get Driver from threadLocalmap
	 * return driver.get(); }
	 */
	
	@BeforeSuite
	public void loadConfig() throws IOException {
		
		DOMConfigurator.configure("log4j.xml");
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "./configuration/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@BeforeClass
	public static void launchApp() {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if(browserName.contains("firefox")) {
			
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
			boolean flag = false;
		  try {
		  
			  driver.get(prop.getProperty("url"));
			  flag = true;
			  
		  }
		  catch(Exception e) {
			  
			  System.out.println("Internet Not Connected"); 
			  flag = false;
		  }finally {
			  if(flag) {
				  System.out.println("URL hitted successfully");
			  }else {
				  System.out.println("Network error. Please check Internet connection!");
			  }
			  
		  }
		 
		
		
		
	}
	
	/*
	 * @AfterClass public static void tearDown() throws InterruptedException {
	 * //Thread.sleep(3000); driver.close();
	 * 
	 * }
	 */
	
	
}
