package com.test.automations.UiPomAutomationsTestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.google.common.io.Files;
import com.test.automations.UiPomAutomations.ExcelReader.excelReader;


public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String url ="http://automationpractice.com/index.php";
	String browser ="firefox";
	excelReader excel;

	
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
	public String[][] getData(String excelName, String sheetName){
		// TestData.xlsx
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\automations\\UiPomAutomationsData\\"+excelName;
		excel = new excelReader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
		 
	}
	public void waitForElement(int timeOutInSeconds, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void getScreenShot(String name){
		Calendar calendra =  Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "\\src\\main\\java\\com\\test\\automations\\UiPomAutomations\\Screenshot\\";
		  File destFile = new File((String) reportDirectory + name+"_"+ formater.format(calendra.getTime()) + ".png");
		  FileUtils.copyFile(scrFile, destFile);
		  Reporter.log("<a href='" + destFile.getAbsolutePath()+"'> <img src='" +destFile.getAbsolutePath()+"'height='100' width='100'/> </a>");
		    
		}
		catch(IOException e){
			e.printStackTrace();
		}
		}
		
	}

