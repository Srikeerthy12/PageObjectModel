package com.test.automations.UiPomAutomationsTestBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String url ="http://automationpractice.com/index.php";
	String browser ="firefox";
	public void init(){
		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
	public void selectBrowser(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			
		 System.setProperty("webdriver.chrome.driver","D:\\Software\\chromdriver11\\chromedriver.exe");
		log.info("creating onject of " +browser);	
		 driver = new ChromeDriver(); 
			
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\workspace\\UiPomAutomations\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver(); 
		}
	}
	public void getUrl(String url){
		log.info("navigating to url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
}
