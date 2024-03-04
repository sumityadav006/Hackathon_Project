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

public class UpcomingBikesObjects extends BasePage{

	
	public UpcomingBikesObjects(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="//div[starts-with(@Id,'headerNewNavWrap')]/nav/div/ul/li[3]")
	WebElement hover_new_bikes;
	
	@FindBy(xpath="//span[@onclick=\"goToUrl('/upcoming-bikes')\"]")
	WebElement upcoming_bikes;
	
	@FindBy(xpath="//div[starts-with(@class,'zw-con pl')]//h1")
	WebElement verify_upcoming_bikes;
	
	@FindBy(xpath="//a[@title='upcoming Honda bikes']")
	WebElement upcoming_honda_bikes;
	
	@FindBy(xpath="//div[starts-with(@class,'zw-con pl')]//h1")
	WebElement verify_upcoming_honda_bikes;
	
	@FindBy(xpath="//span[@class='zw-cmn-loadMore']")
	WebElement load_details;
	
	@FindBy(xpath="//ul[@id='modelList']//a")
	List<WebElement> bikes_names;
	
	@FindBy(xpath="//ul[@id='modelList']//div[starts-with(@class,'b fnt')]")
	List<WebElement> bikes_price;
	
	@FindBy(xpath="//ul[@id='modelList']//div[starts-with(@class,'clr-try fnt')]")
	List<WebElement> bikes_launch_date;
	
	@FindBy(xpath="//div[starts-with(@class,'zw-con pl')]")
	WebElement scroll_back;
	
	@FindBy(xpath="//img[@data-track-label='zw-header-logo']")
	WebElement home_page;
	
	
	
	
	
	public void scroll(WebElement element) {

    	WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait1.until(ExpectedConditions.visibilityOf(element));
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
	
	
	
	
	public void hoverNewBikes(){
		
		Actions action= new Actions(driver);
    	action.moveToElement(hover_new_bikes).perform();
		
	}
	
	
	public void clickUpcomingBikes(){
		
		upcoming_bikes.click();
		
	}
	
	
	public void  validateUpcomingBikesPage() {
		
		String actual_heading="Upcoming Bikes in India";
		String expected_heading=verify_upcoming_bikes.getText().trim();
		Assert.assertEquals(actual_heading,expected_heading );
		
	}
	
	
	public void srollToManufacturerHonda() {
		
		scroll(upcoming_honda_bikes);
		
	}
	
	public void clickHondaBikes() {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",upcoming_honda_bikes);
    	
	}
	
	
    public void  validateUpcomingHondaBikesPage() {
		
		String actual_heading="Honda Upcoming Bikes in India";
		String expected_heading=verify_upcoming_honda_bikes.getText().trim();
		Assert.assertEquals(actual_heading,expected_heading );
		
	}
    
    public void srollToViewMoreBikes() {
		
    	scroll(load_details);
    	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",load_details);
    	
	}
	
    
    public List<List<String>> extractBikeDetails() {
    	
    	
    	List<List<String>> bike_details=new ArrayList<>();
    	
    	String price_conversion;
    	for(int i=0;i<bikes_names.size();i++) {
    		List<String> add_bike_data=new ArrayList<>();
    		String data1= bikes_price.get(i).getText();
    		String data2=bikes_names.get(i).getText();
    		String data3=bikes_launch_date.get(i).getText();
    		String  [] date= data3.split(":");
    		price_conversion=data1.replaceAll("[^\\d.]","").replaceFirst("\\.(?=.*\\.)", "");
    	    double price=Double.parseDouble(price_conversion);
    	    if (price<4) {
    	    	add_bike_data.add(data2);
    	    	add_bike_data.add(data1);
    	    	add_bike_data.add(date[1]);
    	    	bike_details.add(add_bike_data);
    	    	
    	    	
    	    }
    	    
    		
    		
    	}
    	
    	return bike_details;
    	
    	
    }
    
    
    public void displayBikeDetails(List<List<String>> bike_details) throws IOException {
    	
    	String xlfile=System.getProperty("user.dir")+"\\src\\test\\resources\\BikesInfo.xlsx";
    	int row=1;
    	ExcelUtility.setCellData("Bike Details", 0, 0, "Name");
	    ExcelUtility.setCellData("Bike Details", 0, 1, "Price");
	    ExcelUtility.setCellData("Bike Details", 0, 2, "Launch Date");
	    ExcelUtility.fillGreenColor(xlfile,"Bike Details",0,0);
	    ExcelUtility.fillGreenColor(xlfile,"Bike Details",0,1);
	    ExcelUtility.fillGreenColor(xlfile,"Bike Details",0,2);
	    
	    for(List<String> ele: bike_details) {
	    	  System.out.println(ele);
	    	  ExcelUtility.setCellData("Bike Details", row, 0, ele.get(0));
	    	  ExcelUtility.setCellData("Bike Details", row, 1, ele.get(1));
	    	  ExcelUtility.setCellData("Bike Details", row, 2, ele.get(2));
	    	  row++;
	    	
	    	
	    	
	    }
    	
    	
    }
    
    public void srollBackToHeader() {
		
		scroll(scroll_back);
		home_page.click();
		
	}
	
}

