package com.qa.flipkart.BasePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.flipkart.BaseTest.BaseTest;

public class LoginPageTest extends BaseTest {
	@Test
	public void loginPageTitleTest() {
		String title = login.getTitle();
		Assert.assertEquals(title, "ParaBank | Customer Created");

	}
	@Test
	public void loginPageUrl() {
		String url=login.getUrl();
		Assert.assertTrue(url.contains("https://parabank.parasoft.com/parabank/index.htm"));
	}
	
	@Test
	public void forgetPasswordLinkTest() {
		Assert.assertTrue(login.isForgetPasswordLinkTestExist());
	}
	@Test
	public void logoExitTest() {
		Assert.assertTrue(login.isLogoExist());
	}
	
	@Test
	public void doLoginTest() {
		String actualUrl=login.doLogin("kiran", "Test@12345");
		Assert.assertEquals(actualUrl,"ParaBank | Customer Created" );
	}
}

