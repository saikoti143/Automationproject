package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newCustomer {
	WebDriver ldriver;
	public newCustomer(WebDriver rdriver) 
	{
		ldriver =rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(linkText="New Customer")
	@CacheLookup
	WebElement lnkAddnewcustomer;
	
	
}
