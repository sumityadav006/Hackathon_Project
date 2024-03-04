package com.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.ExcelUtility;

public class UsedCarsObjects extends BasePage{
	
	
	public UsedCarsObjects(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//div[starts-with(@Id,'headerNewNavWrap')]/nav/div/ul/li[7]")
	WebElement hover_used_cars;
	
	@FindBy(xpath="//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement location;
	
	@FindBy(xpath="//h1[starts-with(@class,'ro-popup pull-left fnt')]")
	WebElement verify_page;
	
	@FindBy(xpath="//div[@class='gsc_thin_scroll']")
	WebElement popular_models;
	
	@FindBy(xpath="//li[starts-with(@id,'mmvLi')]/span/input")
	List<WebElement> all_popular_models;
	
	@FindBy(xpath="//img[@data-track-label='zw-header-logo']")
	WebElement home_page;
	
	
	
	public void scroll(WebElement element) {

    	WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait1.until(ExpectedConditions.visibilityOf(element));
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
	
	
	public void hoverUsedCars() {
		WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait1.until(ExpectedConditions.visibilityOf(hover_used_cars));
		Actions action= new Actions(driver);
    	action.moveToElement(hover_used_cars).perform();
	}
	
	public void clickLoocation() {
		
		location.click();
		
	}
	
	
    public void  validateUsedCarsPage() {
		
		String actual_heading="Used Cars in Chennai";
		String expected_heading=verify_page.getText().trim();
		Assert.assertEquals(actual_heading,expected_heading );
		
	}
    
    public void scrollToPopularModels() {
    	
    	scroll(popular_models);
    	
    }
    
    
    public List<String> extractDetails() {
    	
    	List<String> popular_models_names=new ArrayList<>();
    	for(WebElement ele: all_popular_models) {
    		
    		String models_names=ele.getAttribute("car_name");
    		popular_models_names.add(models_names);
    		
    	}
    	
    	return popular_models_names;
   
    }
    
    
    public void displayPopularModels(List<String> popular_models_names) throws IOException {
    	
    	
    	String xlfile=System.getProperty("user.dir")+"\\src\\test\\resources\\BikesInfo.xlsx";
    	int row=1;
    	ExcelUtility.setCellData("Popular Models", 0, 0, "Car Name");
	    ExcelUtility.fillGreenColor(xlfile,"Popular Models",0,0);
	    
    	
        for(String ele: popular_models_names) {
        	
        	  System.out.println(ele);
 
        	  ExcelUtility.setCellData("Popular Models", row, 0, ele);
	    	  row++;
        	
    		
    		
    		
    	}
    	
    }
    
    
    public void navigateToHomePage() {
    	
    	home_page.click();
    	
    }

}
