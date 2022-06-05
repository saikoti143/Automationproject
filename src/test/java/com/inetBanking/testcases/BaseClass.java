package com.inetBanking.testcases;





import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig =new ReadConfig();
	
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
      public static Logger logger;
  
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws InterruptedException 
	{
		logger = Logger.getLogger("ebanking");				
	   PropertyConfigurator.configure("log4j.properties");
	    
	    
       if (browser.equals("chrome"))
       {
    	   WebDriverManager.chromedriver().setup(); 
    	   // System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		    driver= new ChromeDriver();
       }
       else if (browser.equals("Edge")) 
       {
    	System.setProperty("webdriver.edge.driver",readconfig.getmsepath());
    	driver = new EdgeDriver();
       }
      
     
       driver.get(baseURL);
       Thread.sleep(5000);
		logger.info("browser launched");
	}
	
	@AfterClass
   public void tearDown()
   {
	   driver.quit();
   }
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot sc = ((TakesScreenshot)driver);
		File source = sc.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	  FileUtils.copyFile(source, target);
	 System.out.println("Screenshot taken");				
	}

	


}
	