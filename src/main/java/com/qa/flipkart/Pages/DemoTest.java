package com.qa.flipkart.Pages;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

		By tvsAndAppliances = By.xpath("//span[text()='TVs & Appliances']");
		By total_Prices = By.xpath("//div[@class='Nx9bqj _4b5DiR']");
		By Product_Name= By.xpath("//div[@class='KzDlHZ\']");
		By Product_Price= By.xpath("//div[@class='Nx9bqj _4b5DiR']");

		driver.findElement(tvsAndAppliances).click();

		Thread.sleep(2000);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(tvsAndAppliances)).build().perform();
		Thread.sleep(2000);
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='jzpKY6']//child::a"));
		System.out.println("total prices: " + ele.size());
		for (WebElement e : ele) {
			String str = e.getText();
			System.out.println(str);
			if (str.equals("Fully Automatic Top Load")) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);

		System.out.println("=======clicked on Fully Automatic Top Load======");
//		driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Price -- High to Low']")))
				.click();
		Thread.sleep(2000);

		List<WebElement> totalprices = driver.findElements(total_Prices);
		System.out.println(totalprices.size());//24
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		for (WebElement p : totalprices) {
			int price = Integer.parseInt(p.getText().replaceAll("[^\\d.]", ""));
			list2.add(price);
			list1.add(price);

//			String  stt=price.replace("₹","");

			System.out.println(price);
		}

		Collections.sort(list2, Collections.reverseOrder());

		for (Integer value : list2) {
			int indexInList1 = list1.indexOf(value);
			int indexInList2 = list2.indexOf(value);

			if (indexInList1 == indexInList2) {

				System.out.println(
						value + " - Index in list1: " + indexInList1 + ", Index in list2: " + indexInList2 + " =Pass");
			} else {
				System.out.println(
						value + " - Index in list1: " + indexInList1 + ", Index in list2: " + indexInList2 + " =Fail");
			}
		}
		
		System.out.println("============");
		List<WebElement>productsname=driver.findElements(Product_Name);
		
		List<WebElement>Totalprice=driver.findElements(Product_Price);
		
		
		for (int i = 0; i < productsname.size(); i++) {
		    String name = productsname.get(i).getText();
		    String price = Totalprice.get(i).getText().replaceAll("[^\\d.]", ""); // remove ₹ etc.

		    System.out.println("Product: " + name + " | Price: " + price);
		}
		
		
		

	}

}
