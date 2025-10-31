package com.qa.flipkart.Factors;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.flipkart.exceptions.BrowserExceptions;

public class Driverfactory {

	WebDriver driver;

	String browser= "chrome";

	public WebDriver initBrowser(String browser) {
		System.out.println("browser name is:>" + browser);

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("browser is not supported"+browser+"invalid");
			throw new BrowserExceptions("======please pass the correct browser Name======"+browser);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		return driver;

	}
}
