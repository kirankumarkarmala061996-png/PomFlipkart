package com.qa.flipkart.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.flipkart.Factors.Driverfactory;
import com.qa.flipkart.Pages.Login_page;

public class BaseTest {

	WebDriver driver;
	Driverfactory factory;

	protected Login_page login;

	@BeforeMethod
	public void setUp() {
		factory = new Driverfactory();
		driver = factory.initBrowser("chrome");
		login = new Login_page(driver);
		
	}

	@BeforeMethod
	public void tearDown() {

		driver.quit();

	}

}
