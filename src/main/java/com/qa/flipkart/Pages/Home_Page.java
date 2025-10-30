package com.qa.flipkart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.flipkart.Constant.AppConstants;
import com.qa.flipkart.Utilities.ElementUtilities;

public class Home_Page {

	WebDriver driver;
	ElementUtilities utils;

	
	By homepagelogo = By.xpath("//div[@class=\"_16ZfEv\"]");
	By home_pageSearchBar= By.xpath("//input[@title=\"Search for Products, Brands and More\"]");
	
	
	
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		utils=new ElementUtilities(driver);
	}
	
	
	
	
	
}