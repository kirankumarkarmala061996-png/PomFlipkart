package com.qa.flipkart.Utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtilities {

	private WebDriver driver;
	private Actions actions;

	public ElementUtilities(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void dosendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doSendKeys(By locater, CharSequence... value) {
		getElement(locater).sendKeys(value);
	}

	public void doSendKeys(By locator, int timeout) {
		getElement(locator).sendKeys(String.valueOf(timeout));
	}

	public void doActionsClick(By locator) {
		actions.click(getElement(locator)).perform();
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Element is not Displayed:" + locator);
			return false;
		}
	}

	public String doGetElementText(By locator) {
		String eleText = getElement(locator).getText();
		if (eleText != null) {
			return eleText;
		} else {
			System.out.println("Text is not present" + eleText);
			return null;
		}
	}

	public String doGetAttribute(By locator, String attributeName) {
		return getElement(locator).getAttribute(attributeName);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public void printElementtext(By locator) {
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
		}
	}

	public boolean isElementNotPresent(By locator) {
		if (getElementsCount(locator) == 0) {
			return true;
		}
		return false;
	}

	public boolean isElementPresentMultipleTimes(By loctor) {
		if (getElementsCount(loctor) >= 1) {
			return true;
		}
		return false;
	}

	public boolean isElementPresent(By locator, int expectedElementCount) {
		if (getElementsCount(locator) == expectedElementCount) {
			return true;
		}
		return false;

	}
	
	public boolean isElementPresent(By locator) {
		if(getElementsCount(locator)==1) {
			return true;
		}
		return false;
	}
	
	public List<String> GetElementstextList(By locator) {
		List<WebElement>elList=getElements(locator);
	List<String>eleTextlist= new ArrayList<String>();
		
		for(WebElement e:elList) {
			String text=e.getText();
			if(text.length()!=0) {
				eleTextlist.add(text);
			}
		}
		return eleTextlist;
	}

	public void doActionsSendKeys(By locator, String value) {
		actions.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsMoveToElement(By locator) {
		actions.moveToElement(getElement(locator)).perform();
	}

	public void doActionsMoveToElementAndClick(By locator) {
		actions.moveToElement(getElement(locator)).click().perform();
	}

	public void doActionsMoveToElementAndClick(By locator, String value) {
		actions.moveToElement(getElement(locator)).sendKeys(value).click().perform();
	}

	/*
	 * Wait Concepts: locators: timeout: polling time: ignoring exception:
	 */

//	elementtobeVisible
	public WebElement waitForelementToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

//	visibilityofAllElements
	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

//	ElementtobeClickable
	public WebElement waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// presenceofElementLocated
	public void waitForElementToBePrescence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

//	waitForPollingTime
	public WebElement waitForPollingTime(By locator, int timeout, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.pollingEvery(Duration.ofMillis(pollingTime));
		wait.ignoring(Exception.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForIgnoringElementClickbleException(By locator, int timeout, int PollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.pollingEvery(Duration.ofMillis(PollingTime));
		wait.ignoring(ElementNotInteractableException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForIgnoreingStalElementexception(By locator, int timeout, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.pollingEvery(Duration.ofMillis(pollingTime));
		wait.ignoring(StaleElementReferenceException.class);
		wait.withMessage("Dom is not refreshed please check");
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public WebElement waitForElementToBeVisibleWithFluentwait(By locator, int timeout, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchMethodError.class)
				.ignoring(StaleElementReferenceException.class).ignoring(ElementNotInteractableException.class)
				.withMessage("Element is not visible please check" + locator);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

//	getPageUrlUsingWait
	public Boolean waitPageUrlContains(String url, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			return wait.until(ExpectedConditions.urlContains(url));
		} catch (TimeoutException e) {
			System.out.println("Url is not matched....");
			return false;
		}
	}

	public @Nullable String getPageUrl(String expectedUrl, int timeout) {
		if (waitPageUrlContains(expectedUrl, timeout)) {
			return driver.getCurrentUrl();
		} else {
//			System.out.println("Url is not matched....");
			return "-1";
		}
	}

	public String waitForUrlContainsAndReturns(String url, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		try {
			wait.until(ExpectedConditions.urlContains(url));// if true it will return the url
			return driver.getCurrentUrl();
		} catch (TimeoutException e) {
			System.out.println("Url is not matched....");
			return "-1";
		}

	}

//	waitForTitleIs
	public boolean waitForTitleIs(String expectedTilte, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			return wait.until(ExpectedConditions.titleIs(expectedTilte));

		} catch (TimeoutException e) {
			System.out.println("Title is not matched....");
			return false;
		}

	}

//getPageTitleUsingWait
	public String getPageTitle(String ExpectedTitle, int timeout) {
		if (waitForTitleIs(ExpectedTitle, timeout)) {
			return driver.getTitle();
		} else {
			return "-1";
		}
	}

	public boolean waitForTitleContains(String fractionTitle, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			return wait.until(ExpectedConditions.titleContains(fractionTitle));

		} catch (TimeoutException e) {
			System.out.println("Title is not matched....");
			return false;
		}

	}

	public String waitForTitleContainsAndReturn(String fractionTitle, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			wait.until(ExpectedConditions.titleContains(fractionTitle));
			return driver.getTitle();
		} catch (TimeoutException e) {
			System.out.println("Title is not matched....");
			return "-1";
		}

	}

	// Alearts

	public Alert waitForAlertAndSwitch(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();

	}

	public String getAlertText(int timeout) {
		return waitForAlertAndSwitch(timeout).getText();

	}

	public void acceptAccept(int timeout) {
		waitForAlertAndSwitch(timeout).accept();
	}

	public void dismissAlert(int timeout) {

		waitForAlertAndSwitch(timeout).dismiss();
	}

	public void sendKeysToAlert(int timeout, String value) {
		waitForAlertAndSwitch(timeout).sendKeys(value);
	}

	public Alert waitForAlertUsingfluentWaitAndSwitch(int timeout) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.ignoring(NoAlertPresentException.class).withMessage("js alert is not present");
		return wait.until(ExpectedConditions.alertIsPresent());
	}

}
