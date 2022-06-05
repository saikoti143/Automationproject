package com.inetBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.pageObjects.Loginpage;

public class TC_Login_Test_001 extends BaseClass 
{
	@Test
	public void Logintest() throws IOException
	{
		
	
		Loginpage lp=new Loginpage(driver);
		
	//	driver.findElement(By.id("details-button")).click();
	//	driver.findElement(By.id("proceed-link")).click();
		lp.setUsername(username);
	
		logger.info("Entered username");
		
		lp.setPassword(password);
		
		logger.info("Entered password");
	
		lp.clicksubmit();
		
		logger.info("Click on submit");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			
			Assert.assertTrue(true);
			logger.info("Test passed");
		}
		else
		{
			captureScreen(driver , "Login Test");
			Assert.assertTrue(false);
			logger.info("Test failed");
		}
	}

}
