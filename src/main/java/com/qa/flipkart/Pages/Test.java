package com.qa.flipkart.Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpRequest;

public class Test {
	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());
		for (int i = 0; i < links.size(); i++) {
			String link = links.get(i).getAttribute("href");
			URL url = new URL(link);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(5000);
			connection.connect();
			int responccecode = connection.getResponseCode();
			if (responccecode >= 400) {
				System.out.println(link + " - " + "is a broken link");
			} else {
				System.out.println(link + " - " + "is a valid link");
			}
		}
	}

}
