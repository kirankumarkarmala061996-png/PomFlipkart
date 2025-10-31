package com.qa.flipkart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Login_page {

	 WebDriver driver;

	public Login_page(WebDriver driver) {
		this.driver = driver;
	}

	private By userName = By.xpath("//input[@name='username']");
	private By passWord = By.xpath("//input[@name='username']");
	private By loginButton = By.xpath("//input[@value='Log In']");
	private By forgotPasswordLink = By.xpath("//a[normalize-space()='Forgot login info?']");
	private By logo = By.xpath("//img[@class='admin']");
	

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getUrl() {
		String currentPageUrl = driver.getTitle();
		return currentPageUrl;
	}

	public boolean isForgetPasswordLinkTestExist() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

	public boolean isLogoExist() {
		return driver.findElement(logo).isDisplayed();
	}

	public String doLogin(String username, String pass) {
		driver.findElement(userName).sendKeys(username);
		driver.findElement(passWord).sendKeys(pass);
		driver.findElement(loginButton).click();
		String homePageTitle = driver.getTitle();
		System.out.println("homepage tile is:" + homePageTitle);
		return homePageTitle;
	}

}
