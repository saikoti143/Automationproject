package com.inetBanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.utilities.XLUtils;
import com.inetBankingV1.pageObjects.Loginpage;

public class TC_Login_DDTest_002 extends BaseClass

{

		@Test(dataProvider="LoginData")
		public void loginDDT(String user,String pwd) throws InterruptedException
		{
			Loginpage lp=new Loginpage(driver);
	
	         lp.setUsername(user);
	         logger.info("Entered username");
			lp.setPassword(pwd);
		 logger.info("Entered password");
			lp.clicksubmit();
			 logger.info("Cliked on submit");
			Thread.sleep(3000);
			
			if(isAlertPresent()==true)
			{
				 logger.info("Login failed");
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
			
			}
			else
			{
				Assert.assertTrue(true);
				 logger.info("Login passed");
				lp.clicklogout();
		
				Thread.sleep(3000);
				driver.switchTo().alert().accept();//close logout alert
				logger.info("Logout successful");
				driver.switchTo().defaultContent();
				
			}
			
			
		}
		
		
		public boolean isAlertPresent() //user defined method created to check alert is present or not
		{
			try
			{
			driver.switchTo().alert();
			return true;
			}
			catch(NoAlertPresentException e)
			{
				return false;
			}
			
		}
		
		
		@DataProvider(name="LoginData")
		String [][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"/testData/LoginData.xlsx";
			
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path,"Sheet1",1);
			
			String logindata[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				}
					
			}
		return logindata;
		}
}

