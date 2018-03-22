package com.test.automations.UiPomAutomations.UIActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.automations.UiPomAutomationsTestBase.TestBase;

public class productDetailsPage extends TestBase {

	public final static Logger log = Logger.getLogger(productDetailsPage.class.getName());
	
	public final String contrast_jacket ="Contrast jacket";
	public final String grey_Jacket ="Grey Jacket";
	public final String offwhitetrenchstyle_jacket = "offwhitetrenchstyle jacket";
	public final String flowerprint_jeans = "flowerprintjeans";
	
	@FindBy(xpath="")
	List<WebElement> products;
	
	public void selectProduct(String product){
		driver.findElement(By.xpath("//a[contains(tetxt(),'" +product+"')]")).click();
		log.info(product+"has been selected");
		
	}
	public List<WebElement> selectProduct(){
		//List<WebElement> element = driver.findElements(By.xpath(""));
		List<WebElement> element = products;
		return element;
	
	}
}
