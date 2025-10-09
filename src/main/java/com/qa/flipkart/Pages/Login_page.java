package com.qa.flipkart.Pages;

import org.openqa.selenium.By;

public class Login_page {

	
	public Login_page() {
		
	}
	
	By email = By.xpath("//input[@class='email']");
	By password = By.xpath("//input[@type='password']");
	By loginButton = By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
	By closeLoginPopup = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	By loginErrorMessage = By.xpath("//span[@class='_2YULOR']");
	By forgotPasswordLink = By.xpath("//a[@class='_1g3afI']");
	By requestOtpLink = By.xpath("//a[@class='_1g3afI']");
	By signUpLink = By.xpath("//a[@class='_1g3afI']");
}
