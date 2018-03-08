package com.test.automations.UiPomAutomations.UIActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automations.UiPomAutomationsTestBase.TestBase;

public class HomePage extends TestBase{
	public static final Logger log = Logger.getLogger(HomePage.class.getName());

//We have planned to use Page Factory
	
	WebDriver driver;
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement loginPassword;

	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement authenicationFailed;
	
	@FindBy(id="PreviewFrame")
	WebElement homepageIframe;
	
	@FindBy(id="customer_register_link")
	WebElement signUpLink;
	
	@FindBy(id="FirstName")
	WebElement firstName;
	
	@FindBy(id="LastName")
	WebElement lastName;
	
	@FindBy(id="Email")
	WebElement email;
	@FindBy(id="CreatePassword")
	WebElement createPassword;
	
	@FindBy(css="input.btn")
	WebElement createAccount;
	
	@FindBy(xpath="getRegistrationSuccessmessage")
	WebElement registrationsmessage;
	

	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

public void LogintoApplications(String emailAddress, String password ){
	signIn.click();
	log.info("clciked on sign in and objectis"+signIn.toString());
	
	loginEmailAddress.sendKeys(emailAddress);
	log.info("Enter emailAddresss"+emailAddress+" and object is "+loginEmailAddress.toString());
	loginPassword.sendKeys(password);
log.info("enetered password "+password+" and object is "+loginPassword.toString());

	submitButton.click();
	log.info("clicked on submit button and object is "+submitButton.toString());
	
	
}
public String getInvalidloginText(){
	log.info("error messsage is "+authenicationFailed.getText());
	return authenicationFailed.getText();
	
	 
}
public void registeruser(String firstName, String lastName, String emailAddress, String password){
	
	driver.switchTo().frame(homepageIframe);
	log.info("Swtiching to homepage frame and frame object is " +homepageIframe.toString());
	signUpLink.click();
	log.info("clciking on the signup link" +signUpLink.toString());
	this.firstName.clear();
	this.firstName.sendKeys("keerthy");
	log.info("first Name" +this.firstName.toString());
	this.lastName.clear();
	this.lastName.sendKeys("bandi");
	log.info("last Name" +this.lastName.toString());
	email.clear();
	email.sendKeys("keerthyandy@gmail.com");
	log.info("enter email" +this.email.toString());
	createPassword.clear();
	createPassword.sendKeys("keerthi23");
	log.info("enter password" +createPassword.toString());
	createAccount.click();
	log.info("clicked on creat account" +createAccount.toString());
	
}
public boolean getRegistrationSuccessmessage(){
	try {
		driver.findElement(By.xpath("")).isDisplayed();
		return true;
	} catch (Exception e) {
		return false;
	}
	
//log.info("registartion message"+registrationsmessage.getText());
	// return registrationsmessage.getText();
}
}