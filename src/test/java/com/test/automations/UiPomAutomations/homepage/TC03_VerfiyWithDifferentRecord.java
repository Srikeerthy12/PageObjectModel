package com.test.automations.UiPomAutomations.homepage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automations.UiPomAutomations.UIActions.HomePage;
import com.test.automations.UiPomAutomationsTestBase.TestBase;

public class TC03_VerfiyWithDifferentRecord extends TestBase{
public static final Logger log = Logger.getLogger(TC03_VerfiyWithDifferentRecord.class.getName());
	
	HomePage homepage;
	
	String emailAddress = "keerthyandy@gmail.com";
	String loginPassword = "keerthi23";
 
 @BeforeTest
  public void setUp(){
	 init();
	 
 }
 @Test
	 public void testLogin(){
	 log.info("====Start TC03_VerfiyWithDifferentRecord----------------");
	 homepage = new HomePage(driver);
	homepage.logindemoSite(emailAddress, loginPassword);
	log.info("-----Finish TC03_VerfiyWithDifferentRecord-----"); 
	 }
	 @AfterTest
	 public void endTest(){
		 driver.close();
	 }
 }

