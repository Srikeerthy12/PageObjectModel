package com.test.automations.UiPomAutomations.LoginPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automations.UiPomAutomations.UIActions.HomePage;
import com.test.automations.UiPomAutomationsTestBase.TestBase;



public class Tc_login extends TestBase{

	public static final Logger log = Logger.getLogger(Tc_login.class.getName());
		
		  //System.setProperty("webdriver.gecko.driver", "D:\\Software\\geckodriver11\\geckodriver.exe");
		//driver = new FirefoxDriver();
		
		 HomePage homepage;
		 
		 @BeforeTest
		 public void setUp(){
			 init();
			 
		/* System.setProperty("webdriver.chrome.driver","D:\\Software\\chromdriver11\\chromedriver.exe");
			driver = new ChromeDriver();
		  driver.get("http://automationpractice.com/index.php"); */ // Here TestBase is the parent class or prior functionality of the web pages //
		 }
		 @Test
		 public void tc_login(){
			 
			/* driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
			 driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("keerthyandy@gmail.com");
			 driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys("keerthia23"); // wrong password
			 driver.findElement(By.xpath(".//*[@id='SubmitLogin']")).click(); */
			 log.info("---Start of Login Verifcation----");
			 homepage = new HomePage(driver);
			 homepage.LogintoApplications("keerthyandy@gmail.com", "keerthia23");
			 Assert.assertEquals(homepage.getInvalidloginText(), "Authentication failed.");
			 log.info("--Finished Verfication Login---");
		 }
		 @AfterTest
		 public void endTest(){
			 driver.close();
		 }
		 
		 }
	

