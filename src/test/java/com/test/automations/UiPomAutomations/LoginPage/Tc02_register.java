package com.test.automations.UiPomAutomations.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automations.UiPomAutomations.UIActions.HomePage;
import com.test.automations.UiPomAutomationsTestBase.TestBase;

public class Tc02_register extends TestBase{
	HomePage homepage;
	String firstName = "keerthy";
	String lastName = "Bandi";
	String emailAddress = "keerthyandy@gmail.com";
	String password = "keerthi23";
	
	@BeforeClass
	 public void setUp(){
		 init();
		 
	/* System.setProperty("webdriver.chrome.driver","D:\\Software\\chromdriver11\\chromedriver.exe");
		driver = new ChromeDriver();
	  driver.get("http://automationpractice.com/index.php"); */ // Here TestBase is the parent class or prior functionality of the web pages //
	 }
	 @Test
	 public void tc02_login(){
		   homepage = new HomePage(driver);
		   homepage.registeruser(firstName, lastName, emailAddress, password);
		   // Assert.assertEquals(arg0, arg1);
		   homepage.getRegistrationSuccessmessage();
		   Assert.assertEquals(true, homepage.getRegistrationSuccessmessage());
		}
		
		
	 
	 @AfterTest
	 public void endTest(){
		 driver.quit();
	 }

}
