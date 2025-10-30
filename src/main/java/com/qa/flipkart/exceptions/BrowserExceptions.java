package com.qa.flipkart.exceptions;

import org.openqa.selenium.bidi.module.Browser;

public class BrowserExceptions extends RuntimeException {
	
	public BrowserExceptions(String ExceptionMessage) {
		super(ExceptionMessage);
	}

}
