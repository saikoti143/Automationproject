package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;




public class Loginpage {

	WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver)
	{
    ldriver= rdriver;
    PageFactory.initElements(rdriver, this);
    	}
	
	@FindBy(name="uid")	
	@CacheLookup
	 WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement btnLogout;
	
	
	public void setUsername(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
		
	}
	public void clicksubmit()
	
	{
		btnLogin.click();
	}
	public void clicklogout()
	{
		btnLogout.click();
	}
}


