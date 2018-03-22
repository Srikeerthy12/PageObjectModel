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
	
	@FindBy(xpath="//*[@id='shopify-section-header']/div/div[2]/span")
	WebElement registrationsmessage;
	
	@FindBy(xpath="//*[@id='customer_login_link']")
	WebElement loginLink;
	
	@FindBy(id="CustomerEmail")
	WebElement loginEmail;
	
	@FindBy(xpath=".//*[@id='CustomerPassword']")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='customer_login']/p[1]/input")
	WebElement clickOnSignIn;
	
	@FindBy(xpath= "")
	WebElement logout;
	
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
	
//log.info("Registration message"+registrationsmessage.getText());
	// return registrationsmessage.getText();
	
	

}

public void logindemoSite(String emailAddress, String loginPassword) {
	loginLink.click();
	loginEmail.sendKeys(emailAddress);
	password.sendKeys(loginPassword);
	clickOnSignIn.click();
	driver.switchTo().defaultContent();
	
}
public boolean verifyLogoutDisplay(){
	try {
		driver.switchTo().frame(homepageIframe);
		//waitForElement(300, logout);
		logout.isDisplayed();
		log.info("===logout message option is displayed-----" +logout.toString());
		return true;
	} catch (Exception e) {
		return false;
	}
}
	public void clickOnLogout(){
		driver.switchTo().frame(homepageIframe);
		logout.click();
		log.info("clicked on Logout button" + logout.toString());
}
public void clickOnNavigationMenu(String menuName){
	driver.findElement(By.xpath("")).click();// write xpath init
  log.info("clcikd on : "+menuName+" navigation menu");
  
  
}
public void clickOnProductInMensSection(String product){
	driver.findElement(By.xpath("")).click();
	}
public void clickOnProductInWomensSection(String product){
	driver.findElement(By.xpath("")).click();
	}
}
