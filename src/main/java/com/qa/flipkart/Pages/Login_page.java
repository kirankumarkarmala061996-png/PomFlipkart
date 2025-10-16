package com.qa.flipkart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Login_page {

	WebDriver driver;
	
	public Login_page(WebDriver driver) {
		this.driver=driver;
	}
	
	By email = By.xpath("//input[@class=\"r4vIwl BV+Dqf\"]");
	By password = By.xpath("//input[@type='password']");
	By closeLoginPopup = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	By loginButton = By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
	By loginErrorMessage = By.xpath("//span[@class='_2YULOR']");
	By forgotPasswordLink = By.xpath("//a[@class='_1g3afI']");
	By requestOtpLink = By.xpath("//a[@class='_1g3afI']");
	By signUpLink = By.xpath("//a[@class='_1g3afI']");
	
	
	
	Actions action = new Actions(driver);
}
