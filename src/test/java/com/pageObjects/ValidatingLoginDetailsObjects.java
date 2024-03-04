package com.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.ExcelUtility;

public class ValidatingLoginDetailsObjects extends BasePage {
	
	
	public ValidatingLoginDetailsObjects(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(xpath="//div[@id='des_lIcon']")
	WebElement login_button;
	
	@FindBy(xpath="//h4[starts-with(@class,'hd-ctr mb-15 zs')]/span[1]")
	WebElement verify_login_page;
	
	@FindBy(xpath="(//div[@class='newgf-login'])[2]")
	WebElement google_signup_button;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email_input;
	
	@FindBy(xpath="(//span[@jsname='V67aGc'])[2]")
	WebElement next;
	
	@FindBy(xpath="//div[starts-with(@class,'o6cuMc')]")
	WebElement error_msg;
	

	@FindBy(xpath="//*[contains(text(),'Dismiss')]")
	WebElement dismiss;
	
	
	
	
	
	public void scroll(WebElement element) {

    	WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait1.until(ExpectedConditions.visibilityOf(element));
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
	
	
	
	public void clickLoginButton() {
		
		login_button.click();
		
	}
	
	
	public void verifyLoginRegisterPage() {
		WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait1.until(ExpectedConditions.visibilityOf(verify_login_page));
		String actual_heading="Login/Register to ZigWheels";
		String expected_heading=verify_login_page.getText().trim();
		
		Assert.assertEquals(actual_heading,expected_heading );
		
		
		
	}
	
	
	public void clickGoogleButton() throws InterruptedException {
		WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait1.until(ExpectedConditions.visibilityOf(google_signup_button));
		google_signup_button.click();
    	
		
	}
	
	
	public void switchToNewWindow() {
		
		
		
		try {
			Set<String> windowHandles = driver.getWindowHandles();
	   	    Iterator<String> iterator = windowHandles.iterator();
	   	    String parentWindow=iterator.next();
			String childWindow = iterator.next();
	        driver.switchTo().window(childWindow);
		}
		catch(Exception e) {
			
			System.out.println("Google button is Not Clickable");
			
		}
		try {
			
			WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(20));
	    	wait1.until(ExpectedConditions.visibilityOf(dismiss));
			dismiss.click();
		}
		catch(Exception e) {
			
		}
        
		
	}
	
	
	public void fillDetails() throws InterruptedException, IOException {
		int row=1;
		String xlfile=System.getProperty("user.dir")+"\\src\\test\\resources\\BikesInfo.xlsx";
		ExcelUtility.fillGreenColor(xlfile,"Login Validation",0,1);
		WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait1.until(ExpectedConditions.visibilityOf(email_input));
    	while(row<4) {
		email_input.sendKeys(ExcelUtility.readExcelData(row));
		scroll(next);
		next.click();
		
		
		try {
			WebDriverWait wait2= new WebDriverWait(driver,Duration.ofSeconds(10));
	    	wait2.until(ExpectedConditions.visibilityOf(error_msg));
    		error_msg.getText();
    		ExcelUtility.setCellData("Login Validation", row, 1, "Invalid");
    		email_input.clear();
    	}
    	catch(Exception e){
    		ExcelUtility.setCellData("Login Validation", row, 1, "Valid");  		
    	}
		row++;
		
		
	}}
	
	public void displayMsg() {
		
		try {
    		System.out.println(error_msg.getText());
    	}
    	catch(Exception e){
    		System.out.println("Entered Valid Email Account");
    		
    	}
		
	}


}
