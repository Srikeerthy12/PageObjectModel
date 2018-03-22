package com.test.automations.UiPomAutomations.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automations.UiPomAutomations.UIActions.HomePage;
import com.test.automations.UiPomAutomationsTestBase.TestBase;

public class TC03_VerfiyWithDifferentRecord extends TestBase{
public static final Logger log = Logger.getLogger(TC03_VerfiyWithDifferentRecord.class.getName());
	
	HomePage homepage;
	//String emailAddress = "keerthyandy@gmail.com";
	//String loginPassword = "keerthi23";
	
	@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords = getData("TestData.xlsx","LoginDATA");
		return testRecords;
	}
 
 @BeforeTest
  public void setUp(){
	 init();
	 
 }
 @Test(dataProvider =" loginData")
	 public void testLogin(String emailAddress, String loginPassword, String runmode){
	 if (runmode.equalsIgnoreCase("n")){
		 throw new SkipException("user marked this record as no run");
	 }
			 
	 log.info("====Start TC03_VerfiyWithDifferentRecord----------------");
	 homepage = new HomePage(driver);
	homepage.logindemoSite(emailAddress, loginPassword);
	boolean status = homepage.verifyLogoutDisplay();
	getScreenShot("testLogin" +emailAddress);
	if(status){
		homepage.clickOnLogout();
	}
	Assert.assertEquals(status,true );
	log.info("-----Finish TC03_VerfiyWithDifferentRecord-----"); 
	 }
	 @AfterTest
	 public void endTest(){
		 driver.close();
	 }
 }

